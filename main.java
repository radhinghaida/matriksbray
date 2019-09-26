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
                GaussEli doGauss = new GaussEli;
                System.out.println("1. Metode eliminasi gauss");
                System.out.println("2. Metode eliminasi gauss jordan");
                System.out.println("3. Metode matriks balikan");
                System.out.println("4. Kaidah cramer");
                System.out.print("Mau diapain nih SPLnya? ");
                Scanner spl = new Scanner(System.in);
                int pilihspl = spl.nextInt();
                System.out.println("Matriksnya mau darimana gan ?");
                System.out.println("1. Input Matriks");
                System.out.println("2. Baca dari File");
                int sourceType = spl.nextInt();
                switch (pilihspl) {
                    case 1:
                        if (sourceType == 1) {
                            int m, n;
                            System.out.print("Masukkan jumlah baris : ");
                            n = spl.nextInt();
                            System.out.print("Masukan jumlah kolom : ");
                            m = spl.nextInt();
                            double[][] matriksSPL = new double[m][n];
                            double[] rightSide = new double[n];
                            currentMatriks.inputMatriks(matriksSPL, m, n);
                            currentMatriks.inputRightSide(rightSide, n);
                            doGauss.GaussEli(matriksSPL, rightSide);
                            System.out.println("Matriks setelah Gauss-elimination = ");
                            result.printMatrix(matriksSPL);

                        }
                        break;

                    case 2:
                    if (sourceType == 1) {
                        int m, n;
                        System.out.print("Masukkan jumlah baris : ");
                        n = spl.nextInt();
                        System.out.print("Masukan jumlah kolom : ");
                        m = spl.nextInt();
                        double[][] matriksSPL = new double[m][n];
                        double[] rightSide = new double[n];
                        currentMatriks.inputMatriks(matriksSPL, m, n);
                        currentMatriks.inputRightSide(rightSide, n);
                        doGauss.GaussJordan(matriksSPL, rightSide);
                        System.out.println("Matriks setelah Gauss-Jordan = ");
                        result.printMatrix(matriksSPL);

                    }
                        break;

                    case 3:

                        break;

                    case 4:

                        break;

                }

                break;

                
            case 2: // Determinan
                GetDeterminant findDet = new Determinant();
                System.out.println("1. Metode eliminasi gauss");
                System.out.println("2. Metode Kofaktor");
                System.out.println("3. Metode Cramer");
                System.out.print("Mau nyari determinan pake apa bray ? ");
                Scanner det = new Scanner(System.in);
                int pilihdet = det.nextInt();
                System.out.println("Matriksnya mau darimana gan ?");
                System.out.println("1. Input Matriks");
                System.out.println("2. Baca dari File");
                int sourceType = det.nextInt();

                switch (pilihdet) {

                    case 1:
                        if (sourceType == 1) {
                            int n;
                            double valDet;
                            char answer;
                            System.out.print("Masukkan N (Matriks N x N) : ");
                            n = spl.nextInt();
                            double[][] matriksDet = new double[n][n];
                            double[][] copyMatDet = new double[n][n];
                            currentMatriks.inputMatriks(matriksDet, n, n);
                            copyMatDet = currentMatriks.CopyMatriks(matriksDet);
                            valDet = findDet.gaussDeterminant(matriksDet);
                            System.out.println("Determinan dari Matriks diatas adalah = " + valDet);
                            System.out.println("");
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = det.next().charAt(0);
                            if (answer == 'y') {
                                result.SaveMatriksIntoFile(copyMatDet);
                                result.SaveDeterminantIntoFile(valDet);
                            }

                        }
                        else {
                            System.out.println("Lagi dibuat sama radhin bray");

                        }
                        break;

                    case 2:
                    if (sourceType == 1) {
                        int n;
                        double valDet;
                        char answer;
                        System.out.print("Masukkan N (Matriks N x N) : ");
                        n = spl.nextInt();
                        double[][] matriksDet = new double[n][n];
                        double[][] copyMatDet = new double[n][n];
                        currentMatriks.inputMatriks(matriksDet, n, n);
                        copyMatDet = currentMatriks.CopyMatriks(matriksDet);
                        valDet = findDet.cofDeterminant(matriksDet);
                        System.out.println("Determinan dari Matriks diatas adalah = " + valDet);
                        System.out.println("");
                        System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                        answer = det.next().charAt(0);
                        if (answer == 'y') {
                            result.SaveMatriksIntoFile(copyMatDet);
                            result.SaveDeterminantIntoFile(valDet);
                        }

                    }

                        break;

                    case 3:

                        break;

                }

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
