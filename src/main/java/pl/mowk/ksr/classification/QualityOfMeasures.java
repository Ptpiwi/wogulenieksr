package pl.mowk.ksr.classification;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class QualityOfMeasures {
    private float accuracy;
    private float precision;
    private float recall;
    private float precision_usa;
    private float recall_usa;
    private float precision_uk;
    private float recall_uk;
    private float precision_wg;
    private float recall_wg;
    private float precision_france;
    private float recall_france;
    private float precision_canada;
    private float recall_canada;
    private float precision_japan;
    private float recall_japan;
    private float f1;

    public float calculateAcc(List<String> predicted, List<String> actual){
        int trues = 0;
        for(int i = 0; i < predicted.size(); i++) {
            if (predicted.get(i).equals(actual.get(i))) {
                trues++;
            }
        }
        return (float) trues / predicted.size();
    }

    public float calculatePrecisionForAll (List<String> predicted, List<String> actual, List<String> labels) {
        int truePositives = 0;
        int falsePositives = 0;
        for (String label : labels) {
            int truePositive = 0;
            int falsePositive = 0;
            for (int i = 0; i < predicted.size(); i++) {
                if (predicted.get(i).equals(label)) {
                    if (predicted.get(i).equals(actual.get(i))) {
                        truePositive++;
                    } else {
                        falsePositive++;
                    }
                }
            }
            truePositives += truePositive;
            falsePositives += falsePositive;
        }
        return (float) truePositives / (truePositives + falsePositives);
    }

    public float calculateRecallForAll (List<String> predicted, List<String> actual, List<String> labels) {
        int truePositives = 0;
        int falseNegatives = 0;
        for (String label : labels) {
            int truePositive = 0;
            int falseNegative = 0;
            for (int i = 0; i < predicted.size(); i++) {
                if (actual.get(i).equals(label)) {
                    if (predicted.get(i).equals(actual.get(i))) {
                        truePositive++;
                    } else {
                        falseNegative++;
                    }
                }
            }
            truePositives += truePositive;
            falseNegatives += falseNegative;
        }
        return (float) truePositives / (truePositives + falseNegatives);
    }

    public float calculatePrecision (List<String> predicted, List<String> actual, String label) {
//        float precisions=0;
        int truePositive = 0;
        int falsePositive = 0;
        for (int i = 0; i < predicted.size(); i++){
            if (predicted.get(i).equals(label)){
                if (predicted.get(i).equals(actual.get(i))){
                    truePositive++;
                    } else {
                    falsePositive++;
                }
            }
        }
        return (float) truePositive / (truePositive + falsePositive);
    }

    public float calculateRecall (List<String> predicted, List<String> actual, String labels) {

        int truePositive = 0;
        int falseNegative = 0;
        for (int j=0; j<predicted.size(); j++){
            if (actual.get(j).equals(labels)) {
                if (predicted.get(j).equals(actual.get(j))) {
                    truePositive++;
                } else {
                    falseNegative++;
                }
            }
        }
        return (float) truePositive / (truePositive + falseNegative);
    }

    public float calculateF1 (List<String> predicted, List<String> actual, List<String> labels){
        float P = calculatePrecisionForAll(predicted,actual,labels);
        float R = calculateRecallForAll(predicted,actual,labels);
        return (2*P*R)/(P+R);
    }

    public float getAccuracy() { return accuracy; }

    public void setAccuracy(float accuracy) { this.accuracy = accuracy; }

    public float getPrecision() { return precision; }

    public void setPrecision(float precision) { this.precision = precision; }

    public float getRecall() { return recall; }

    public void setRecall(float recall) { this.recall = recall; }

    public float getPrecision_usa() { return precision_usa; }

    public void setPrecision_usa(float precision_usa) { this.precision_usa = precision_usa; }

    public float getRecall_usa() { return recall_usa; }

    public void setRecall_usa(float recall_usa) { this.recall_usa = recall_usa; }

    public float getPrecision_uk() { return precision_uk; }

    public void setPrecision_uk(float precision_uk) { this.precision_uk = precision_uk; }

    public float getRecall_uk() { return recall_uk; }

    public void setRecall_uk(float recall_uk) { this.recall_uk = recall_uk; }

    public float getPrecision_wg() { return precision_wg; }

    public void setPrecision_wg(float precision_wg) { this.precision_wg = precision_wg; }

    public float getRecall_wg() { return recall_wg; }

    public void setRecall_wg(float recall_wg) { this.recall_wg = recall_wg; }

    public float getPrecision_france() { return precision_france; }

    public void setPrecision_france(float precision_france) { this.precision_france = precision_france; }

    public float getRecall_france() { return recall_france; }

    public void setRecall_france(float recall_france) { this.recall_france = recall_france; }

    public float getPrecision_canada() { return precision_canada; }

    public void setPrecision_canada(float precision_canada) { this.precision_canada = precision_canada; }

    public float getRecall_canada() { return recall_canada; }

    public void setRecall_canada(float recall_canada) { this.recall_canada = recall_canada; }

    public float getPrecision_japan() { return precision_japan; }

    public void setPrecision_japan(float precision_japan) { this.precision_japan = precision_japan; }

    public float getRecall_japan() { return recall_japan; }

    public void setRecall_japan(float recall_japan) { this.recall_japan = recall_japan; }

    public float getF1() { return f1; }

    public void setF1(float f1) { this.f1 = f1; }
}
