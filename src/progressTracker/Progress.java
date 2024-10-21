package progressTracker;

public class Progress {
    private boolean result;
    private Double percentDone;

    public Progress(boolean result, Double percentDone) {
        this.result = result;
        this.percentDone = percentDone;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Double getPercentDone() {
        return percentDone;
    }

    public void setPercentDone(Double percentDone) {
        this.percentDone = percentDone;
    }
}
