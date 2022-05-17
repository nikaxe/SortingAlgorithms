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

        int numberOfTests = 100;
        //double[] results = new double[numberOfTests];
        Double average = 0.0;
        for(int i = 0; i < numberOfTests; i++){
            average += Double.parseDouble(Bench.execute(Bench.countingSort, randomSample).replace(',', '.'));
        }
        average /= 100.0;
        System.out.printf("%6f%n",average);
        //String test = Bench.execute(Bench.countingSort, randomSample);
        //test = test.replace(',', '.');
        //System.out.println(test);
        //System.out.println(Double.parseDouble(test));
    }
}
