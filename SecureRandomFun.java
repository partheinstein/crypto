import java.security.SecureRandom;

public class SecureRandomFun {

    public static void main(String[] args) throws Exception {

        print(new SecureRandom());

        // this may block
        // the algorithm used is specified in java.security file
        // property: securerandom.strongAlgorithms
        // default is NativePRNGBlocking, provider is Sun
        print(SecureRandom.getInstanceStrong());
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
