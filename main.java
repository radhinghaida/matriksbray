import java.util.Scanner;

class main {
    public static void main(String[] args) {

        GetMatriks currentMatriks = new GetMatriks();
        Output result = new Output();
        Scanner input = new Scanner(System.in);

        System.out.println("SELAMAT DATANG PARA INSAN YANG INGIN MENYELESAIKAN MATRIKS");
        System.out.println("--------------- MENU ---------------");
        System.out.println("");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks Balikan");
        System.out.println("4. Matriks Kofaktor");
        System.out.println("5. Adjoin");
        System.out.println("6. Interpolasi");
        System.out.println("7. Keluar");
        System.out.println("\n Silahkan pilih menu yang diinginkan!");
        Scanner pilih = new Scanner(System.in);
        int pilihmenu = pilih.nextInt();
        System.out.println("\n");
        switch (pilihmenu) {
            case 1:
                System.out.println("1. Metode eliminasi gauss");
                System.out.println("2. Metode eliminasi gauss jordan");
                System.out.println("3. Metode matriks balikan");
                System.out.println("4. Kaidah cramer");
                System.out.println("Mau diapain nih SPLnya?");
                Scanner spl = new Scanner(System.in);
                int pilihspl = spl.nextInt();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
            
                // Interpolasi
                Interpolasi getInter = new Interpolasi();
                int jumlahInterpolasi;
                jumlahInterpolasi = input.nextInt();
                double[][] persamaanInter = new double[n][n];
                double[] hasilInter = new doube[n];
                currentMatriks.inputMatriksInterpolasi(persamaanInter, hasilInter, n);
                getInter.solveInterpolasi(persamaanInter, hasilInter);
                getInter.approx(persamaanInter, hasilInter);

                break;
            case 7:
                break;
            default:
                System.out.println("Menu yang anda pilih tidak sesuai bray!");
        }  
    }
}
