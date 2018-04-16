package domain;

public class Speler {
    private String naam;
    private int score;


    public Speler(String naam) throws DomainException {
        if (naam == null || naam.trim().isEmpty()) {
            throw new DomainException("naam mag niet leeg zijn");
        }
        this.naam = naam;
        this.score = 0;
    }

    public String getNaam() {
        return naam;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int score) throws DomainException{
        this.score += score;
        if ( this.score < 0 ) {
            throw new DomainException("score mag niet 0 zijn");
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Speler) {
            Speler s = (Speler) o;
            if (s.naam.equals(this.naam) && s.score == this.score)
                return true;
        }
        return false;
    }

    public String toString() {
        return this.naam + " heeft als score: " + score;
    }



}