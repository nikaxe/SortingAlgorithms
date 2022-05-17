public class BenchMany {
    public static void main(String[] args){
        int size = 100;
        int[] sortedSample = Bench.generateSample(size, 0, 1.0f);
        int[] partiallySortedSample = Bench.generateSample(size, 5, 1.0f);
        int[] randomSamplekn05 = Bench.generateSample(size, 100,0.5f);
        int[] randomSample = Bench.generateSample(size, 100,1.0f);
        int[] randomSamplekn10 = Bench.generateSample(size, 100,10f);
        int[] randomSamplekn100 = Bench.generateSample(size, 100,100f);
        int[] randomSamplekn1000 = Bench.generateSample(size, 100,1000f);

        int numberOfTests = 10;
        //double[] results = new double[numberOfTests];
        //Double average = 0.0;
        double[] average = new double[7];
        for(int i = 0; i < numberOfTests; i++){
            average[0] += Double.parseDouble(Bench.execute(Bench.bucketSort, sortedSample).replace(',', '.'));
            average[1] += Double.parseDouble(Bench.execute(Bench.bucketSort, partiallySortedSample).replace(',', '.'));
            average[2] += Double.parseDouble(Bench.execute(Bench.bucketSort, randomSamplekn05).replace(',', '.'));
            average[3] += Double.parseDouble(Bench.execute(Bench.bucketSort, randomSample).replace(',', '.'));
            average[4] += Double.parseDouble(Bench.execute(Bench.bucketSort, randomSamplekn10).replace(',', '.'));
            average[5] += Double.parseDouble(Bench.execute(Bench.bucketSort, randomSamplekn100).replace(',', '.'));
            average[6] += Double.parseDouble(Bench.execute(Bench.bucketSort, randomSamplekn1000).replace(',', '.'));
        }
        for(int i = 0; i < average.length; i++) {
            average[i] /= numberOfTests;
            System.out.printf("%6f%n",average[i]);
        }

        //String test = Bench.execute(Bench.countingSort, randomSample);
        //test = test.replace(',', '.');
        //System.out.println(test);
        //System.out.println(Double.parseDouble(test));
    }
}
