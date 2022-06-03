public class BenchMany2 {
    public static void main(String[] args){

        int[] inputs = new int[]{10, 30, 100, 300, 1000, 3000, 10000, 30000, 100000};

        for (int input : inputs) {
            int size = input;
            int[] sortedSample = Bench.generateSample(size, 0, 1.0f);
            int[] partiallySortedSample = Bench.generateSample(size, 5, 1.0f);
            int[] randomSamplekn05 = Bench.generateSample(size, 100, 0.5f);
            int[] randomSample = Bench.generateSample(size, 100, 1.0f);
            int[] randomSamplekn10 = Bench.generateSample(size, 100, 10f);
            int[] randomSamplekn100 = Bench.generateSample(size, 100, 100f);
            int[] randomSamplekn1000 = Bench.generateSample(size, 100, 1000f);

            int numberOfTests = 10;
            double[] average = new double[7];

            for (int i = 0; i < numberOfTests; i++) {
                average[0] += Double.parseDouble(Bench.execute(Bench.eCountingSort, sortedSample).replace(',', '.'));
                average[1] += Double.parseDouble(Bench.execute(Bench.eCountingSort, partiallySortedSample).replace(',', '.'));
                average[2] += Double.parseDouble(Bench.execute(Bench.eCountingSort, randomSamplekn05).replace(',', '.'));
                average[3] += Double.parseDouble(Bench.execute(Bench.eCountingSort, randomSample).replace(',', '.'));
                average[4] += Double.parseDouble(Bench.execute(Bench.eCountingSort, randomSamplekn10).replace(',', '.'));
                average[5] += Double.parseDouble(Bench.execute(Bench.eCountingSort, randomSamplekn100).replace(',', '.'));
                average[6] += Double.parseDouble(Bench.execute(Bench.eCountingSort, randomSamplekn1000).replace(',', '.'));
            }

            for (int i = 0; i < average.length; i++) {
                average[i] /= numberOfTests;
                System.out.printf("%6f%n", average[i]);
            }
        }
    }
}
