import java.util.ArrayList;

public abstract class Radio implements RadioInterface {

    private boolean isOn = false;
    private boolean isAM = true;
    private double station = 530;
    private double minAM = 530;
    private double maxAM = 1610;
    private double minFM = 87.9;
    private double maxFM = 107.9;
    private ArrayList<Integer> listAM = [];
    private ArrayList<Double> listFM = [];


    @Override
    public void toggle() {
        this.isOn = !isOn;
    }

    @Override
    public boolean getState() {
        return this.isOn;
    }

    @Override
    public void changeFrequency() {
        this.isAM = !isAM;
    }

    @Override
    public void changeStation(boolean up) {
        if (isAM) {
            if (up) {
                this.station += 10;
                if (station >= maxAM) {
                    station = minAM;
                }
            } else if (!up) {
                this.station -= 10;
                if (station <= minAM) {
                    station = maxAM;
                }
            }
        } else if (!isAM) {
            if (up) {
                this.station += 0.2;
                if (station >= maxFM) {
                    station = minFM;
                }
            } else if (!up) {
                this.station -= 0.2;
                if (station <= minFM) {
                    station = maxFM;
                }
            }
        }
    }

    @Override
    public boolean getFrequency() {
        return this.isAM;
    }

    @Override
    public void saveStation(int numButton) {
        if (isAM) {
            this.listAM.set(numButton, (int) this.getStation());
        } else if (!isAM) {
            this.listFM.set(numButton, this.getStation());
        }
    }

    @Override
    public void changeStationButton(int numButton) {
        if (isAM) {
            this.station = this.listAM.get(numButton);
        } else if (!isAM) {
            this.station = this.listFM.get(numButton);
        }
    }

    @Override
    public double getStation() {
        return station;
    }
}
