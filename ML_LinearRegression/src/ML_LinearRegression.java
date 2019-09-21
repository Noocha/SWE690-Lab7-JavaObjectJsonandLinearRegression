import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

public class ML_LinearRegression {
    public static void main(String[] args) {
        process("src/icecreamSale_Train.arff", "src/icecreamSale_Test.arff", "src/icecreamSale_Predict.arff");
        process("src/adsRevenue_Train.arff", "src/adsRevenue_Test.arff", "src/adsRevenue_Predict.arff");
    }

    public static Instances getDataSet(String fileName) {
        try {
            ArffLoader loader = new ArffLoader();
            loader.setFile(new File(fileName));
            Instances dataSet = loader.getDataSet();
            dataSet.setClassIndex(1);
            return dataSet;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void process(String trainFileName, String testFileName, String predictFileName) {
        try {
            Instances trainingDataSet = getDataSet(trainFileName);
            Instances testingDataSet = getDataSet(testFileName);

            //choose type of suppervised learning to be Linear Regression
            Classifier classifier = new LinearRegression();
            classifier.buildClassifier(trainingDataSet);

            Evaluation eval = new Evaluation(trainingDataSet);
            eval.evaluateModel(classifier, testingDataSet);

            System.out.println("Linear Regression");
            System.out.println(eval.toSummaryString());
            System.out.println("Expression for the input data");
            System.out.println(classifier);

            //Predicting
            System.out.println("Prediction");
            Instance predictingDataSet = getDataSet(predictFileName).lastInstance();
            double value = classifier.classifyInstance(predictingDataSet);
            System.out.println("Predict value of Temperature 14.4 ");
            System.out.println(value);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
