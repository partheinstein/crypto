import java.security.SecureRandom;

public class SecureRandomFun {
    // -Djava.security.debug="provider,engine=SecureRandom"
    public static void main(String[] args) throws Exception {

        //        print(new SecureRandom());

        // this may block
        // the algorithm used is specified in java.security file
        // property: securerandom.strongAlgorithms
        // default is NativePRNGBlocking, provider is Sun
        //        print(SecureRandom.getInstanceStrong());


        SecureRandom r = new SecureRandom();
        r.setSeed(new byte[]{1});

        for (int i = 0; i < 4; i++) {
            byte[] v = new byte[1];
            r.nextBytes(v);
            System.out.print(v[0]);
        }
        System.out.println();

        SecureRandom r2 = new SecureRandom();
        r2.setSeed(new byte[]{1});

        for (int i = 0; i < 4; i++) {
            byte[] v = new byte[1];
            r2.nextBytes(v);
            System.out.print(v[0] + " ");
        }
        System.out.println();
            
    }

    private static void print(SecureRandom r) throws Exception {
        System.out.println("prov:" + r.getProvider());
        System.out.println("alg:" + r.getAlgorithm());
        byte[] rBytes = new byte[8];
        r.nextBytes(rBytes);
        for(byte b : rBytes) {
            System.out.print(b + " ");
        }
        System.out.println();

    }
}
