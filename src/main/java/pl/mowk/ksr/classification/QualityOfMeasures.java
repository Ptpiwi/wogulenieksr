package pl.mowk.ksr.classification;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class QualityOfMeasures {
    private float accuracy;
    private float precision;
    private float recall;

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
}
