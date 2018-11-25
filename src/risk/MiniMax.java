package risk;

import java.util.ArrayList;
import java.util.*;

public class MiniMax extends Player {

    static int MaxDepth = 5;

    MiniMax() {
        territories = new ArrayList<Integer>();
        soldier_of_each_territory = new int[EGYPT_TERRITORIES];
    }

    int heuristic(Player a, int mapSz) {
        int total = 0, maxHeuristic = Integer.MIN_VALUE, hasOneSoldier = 0;
        for (int i = 0; i < a.territories.size(); i++) {
            total = 0;
            if (a.soldier_of_each_territory[a.territories.get(i)] == 1) {
                hasOneSoldier = 1;
            }
            ArrayList<Integer> neighbours = AdjacencyMatrix.getNeighbours(a.territories.get(i), mapSz);
            for (int j = 0; j < neighbours.size(); j++) {
                total = 0;
                if (a.isMine(neighbours.get(j))) {
                    continue;
                }
                if (a.getSoldiers_from_territory(neighbours.get(j)) > 1 && hasOneSoldier == 1) {
                    total++;
                }
                total -= a.getSoldiers_from_territory(neighbours.get(j));
                ArrayList<Integer> neighboursOfNeighbours = AdjacencyMatrix.getNeighbours(neighbours.get(j), mapSz);
                int cnt = 0;
                for (int k = 0; k < neighboursOfNeighbours.size(); k++) {
                    if (a.isMine(neighboursOfNeighbours.get(k))) {
                        continue;
                    }
                    cnt++;
                }
                total += cnt;
                maxHeuristic = Math.max(maxHeuristic, total);

            }
        }
        return maxHeuristic;
    }

    double getDiceProbability(int a, int b) {
        ///
        if (a == 3 && b == 2) {
            return 0.3717;
        }
        if (a == 3 && b == 1) {
            return 0.6597;
        }
        if (a == 2 && b == 2) {
            return 0.2276;
        }
        if (a == 2 && b == 1) {
            return 0.5787;
        }
        if (a == 1 && b == 1) {
            return 0.4167;
        }
        if (a == 1 && b == 2) {
            return 0.2546;
        }

        return 1.0;
    }

    Player makeChangesFirst(Player a, Player b, int from, int to, int x, int y, boolean win) { // returns effects to
        // first player
        if (win) {
            if (b.getSoldiers_from_territory(to) == y) {
                a.addTerritory(to, 1);
                a.removeSoldiers(from, 1);
            }
        } else {
            a.removeSoldiers(from, x);
            if (a.getSoldiers_from_territory(from) == 0) {
                a.removeTerritory(from);
            }
        }
        return a;
    }

    Player makeChangesSecond(Player a, Player b, int from, int to, int x, int y, boolean win) { // returns effects to
        // first player
        if (win) {

        } else {
            b.removeSoldiers(to, y);
            if (b.getSoldiers_from_territory(to) == 0) {
                b.removeTerritory(to);
            }
        }
        return b;
    }

    int optimalFrom = -1, optimalTo, optimalS1, optimalS2;

    double getMiniMax(Player a, Player b, int depth, int mapSz, double pathProbability, boolean isMax) {
        if (depth == 0) {
            return heuristic(a, mapSz) * pathProbability;
        }
        double mx1 = 0.0, mn1 = 1.0;
        for (int i = 0; i < a.territories.size(); i++) {
            ArrayList<Integer> neighbours = AdjacencyMatrix.getNeighbours(a.territories.get(i), mapSz);

            /// one soldier cannot attack
            if (a.soldier_of_each_territory[a.territories.get(i)] == 1) {
                continue;
            }

            for (int j = 0; j < neighbours.size(); j++) {
                if (a.isMine(neighbours.get(j))) {
                    continue;
                }

                /// now we have 2 countries to attack each other
                for (int dice1 = 1; dice1 < Math.min(4, a.soldier_of_each_territory[a.territories.get(i)]); dice1++) {
                    for (int dice2 = 1; dice2 <= Math.min(2, b.soldier_of_each_territory[b.territories.get(j)]); dice2++) {

                        int from = a.territories.get(i);
                        int to = neighbours.get(j);
                        double tmp = mx1;
                        mx1 = Math.max(mx1,
                                getMiniMax(makeChangesSecond(a, b, from, to, dice1, dice2, false),
                                        makeChangesFirst(a, b, from, to, dice1, dice2, true), depth - 1, mapSz,
                                        pathProbability * getDiceProbability(dice1, dice2), !isMax));
                        if (isMax && tmp < mx1 && depth == 1) {
                            optimalFrom = from;
                            optimalTo = to;
                            optimalS1 = dice1;
                            optimalS2 = dice2;

                        }
                        mn1 = Math.min(mn1,
                                getMiniMax(makeChangesSecond(a, b, from, to, dice1, dice2, true),
                                        makeChangesFirst(a, b, from, to, dice1, dice2, false), depth - 1, mapSz,
                                        pathProbability * (1.0 - getDiceProbability(dice1, dice2)), !isMax));

                    }
                }

            }
        }
        if (isMax) {
            return mx1;
        }
        return mn1;
    }

    @Override
    public void distribute_soldiers(int k) {
        for (int i = 0; i < k; i++) {
            int chosen = new Random().nextInt(territories.size());
            addSoldiers(chosen, 1);

        }
    }

    @Override
    public void simulate_attack(Player opponent, int mapSz) {
    }

    @Override
    public void startAttack(Player opponent, int mapSz) {
        getMiniMax(this, opponent, 1, mapSz, 1.0, true);
        if (optimalFrom != -1) {
            fightStart(this, opponent, optimalS1, optimalS2, optimalFrom, optimalTo);
        } else {
            GameSimulator.status.didAttack = false;
        }
    }

}
