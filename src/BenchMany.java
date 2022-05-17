public class BenchMany {
    public static void main(String[] args){

        //int[] sortedSample = Bench.generateSample(size, 0, 1.0f);
        //int[] partiallySortedSample = Bench.generateSample(size, 5, 1.0f);
        //int[] randomSamplekn05 = Bench.generateSample(size, 100,0.5f);
        //int[] randomSample = Bench.generateSample(size, 100,1.0f);
        //int[] randomSamplekn10 = Bench.generateSample(size, 100,10f);
        //int[] randomSamplekn100 = Bench.generateSample(size, 100,100f);
        //int[] randomSamplekn1000 = Bench.generateSample(size, 100,1000f);
        //int[] SIZE = new int[]{10, 30, 100, 300, 1000, 3000, 10000, 30000, 100000};
        int[] SIZE = new int[]{10, 30, 100, 300, 1000, 3000, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
        int numberOfTests = 10;
        Bench.Function<int[], int[]> sortingAlgo = Bench.bucketSort;
        double[][] average = new double[SIZE.length][7];

        for(int j = 0; j < SIZE.length; j++){
            for(int i = 0; i < average[j].length; i++) {
                average[j][0] += Double.parseDouble(Bench.execute(sortingAlgo, Bench.generateSample(SIZE[j], 0, 1.0f)).replace(',', '.'));
                average[j][1] += Double.parseDouble(Bench.execute(sortingAlgo, Bench.generateSample(SIZE[j], 5, 1.0f)).replace(',', '.'));
                average[j][2] += Double.parseDouble(Bench.execute(sortingAlgo, Bench.generateSample(SIZE[j], 100,0.5f)).replace(',', '.'));
                average[j][3] += Double.parseDouble(Bench.execute(sortingAlgo, Bench.generateSample(SIZE[j], 100,1.0f)).replace(',', '.'));
                average[j][4] += Double.parseDouble(Bench.execute(sortingAlgo, Bench.generateSample(SIZE[j], 100,10f)).replace(',', '.'));
                average[j][5] += Double.parseDouble(Bench.execute(sortingAlgo, Bench.generateSample(SIZE[j], 100,100f)).replace(',', '.'));
                average[j][6] += Double.parseDouble(Bench.execute(sortingAlgo, Bench.generateSample(SIZE[j], 100,1000f)).replace(',', '.'));
            }
            System.out.println("size: "+ SIZE[j]);
            for(int i = 0; i < average[j].length; i++) {
                average[j][i] /= numberOfTests;
                System.out.printf("%6f%n",average[j][i]);
            }
        }
    }
}
