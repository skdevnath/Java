package com.score;

class Team {
    final String name;
    int point = 0;

    public Team(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public int updatePoint(int scoreEarned) {
        this.point += scoreEarned;
        return this.point;
    }

    public int getPoint() {
        return this.point;
    }
}
