package nl.ica.oose.dea;

public class Amdahl {

    public void Amdahl() {} ;

    public double CalculateSpeedupFactor (int n, double f) throws IllegalArgumentException {
        if (n <= 0 || f < 0 || f > 1) {
            throw new IllegalArgumentException();
        }

        return n / (1 + f * (n -1));
    }

    public double CalculateEfficiency (double speedupfactor, int n) throws IllegalArgumentException{
        if (speedupfactor <= 0 || n <= 0) {
            throw new IllegalArgumentException();
        }
        return speedupfactor / n;
    }
}