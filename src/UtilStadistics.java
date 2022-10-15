import java.util.List;

public class UtilStadistics {
    static double calculateMean(double total, List<Integer> list) {
        return total/list.size();
    }
    static double calculateVariance(double total, List<Integer> list) {
        double mean = calculateMean(total, list);

        return list.stream()
                .map(a -> (a-mean)*(a-mean))
                .reduce(0d, Double::sum)/(list.size()-1);
    }
    static double calculateStandardDeviation(double total, List<Integer> list)
    {
        return Math.sqrt(calculateVariance(total, list));
    }
}
