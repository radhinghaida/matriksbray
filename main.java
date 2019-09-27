import java.util.Scanner;

class main {
    public static void main(String[] args) {

        int sourceType;
        GetMatriks currentMatriks = new GetMatriks();
        LoadFile load = new LoadFile();
        Output result = new Output();
        Scanner input = new Scanner(System.in);

        System.out.println("SELAMAT DATANG PARA INSAN YANG INGIN MENYELESAIKAN MATRIKS");
        System.out.println("        --------------- MENU ---------------");
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
        Scanner spl = new Scanner(System.in);
        System.out.println("\n");
        switch (pilihmenu) {
            
            case 1:
                GaussEli doGauss = new GaussEli();
                System.out.println("1. Metode eliminasi gauss");
                System.out.println("2. Metode eliminasi gauss jordan");
                System.out.println("3. Metode Cramer");
                System.out.print("Mau diapain nih SPLnya? ");
                int pilihspl = spl.nextInt();
                System.out.println("Matriksnya mau darimana gan ?");
                System.out.println("1. Input Matriks");
                System.out.println("2. Baca dari File");
                sourceType = spl.nextInt();
                switch (pilihspl) {
                    case 1:
                        if (sourceType == 1) {
                            int m, n;
                            char answer;
                            System.out.print("Masukkan jumlah baris : ");
                            n = spl.nextInt();
                            System.out.print("Masukan jumlah kolom : ");
                            m = spl.nextInt();
                            double[][] matriksSPL = new double[m][n];
                            double[] rightSide = new double[n];
                            currentMatriks.inputMatriks(matriksSPL, m, n);
                            currentMatriks.inputRightSide(rightSide, n);
                            System.out.println("Apakah hasil akan disimpan (y/n) ?");
                            answer = pilih.next().charAt(0);
                            if (answer == 'y') {
                                doGauss.GaussEli(matriksSPL, rightSide);
                                System.out.println("Matriks setelah Gauss-elimination = ");
                                result.printMatrix(matriksSPL);
                                result.solveSPLSave(matriksSPL, rightSide);
                            }
                            else {
                                doGauss.GaussEli(matriksSPL, rightSide);
                                System.out.println("Matriks setelah Gauss-elimination = ");
                                result.printMatrix(matriksSPL);
                                doGauss.solveSPL(matriksSPL, rightSide);
                            }

                        }
                        else {
                            int row, col;
                            char answer;
                            row = 0;
                            col = 0;
                            LoadFile loadfile = new LoadFile();
                            loadfile.LoadMatriks(col, row);
                            double[][] Aug = new double[col][row];
                            Aug = loadfile.LoadMatriks(col, row);
                            double[][] A = new double[col-1][row];
                            double[] B = new double[row];

                            A = currentMatriks.convertAugtoNormalMat(Aug);
                            B = currentMatriks.convertAugtoNormalRightSide(M);
                            System.out.println("Apakah hasil akan disimpan (y/n) ?");
                            answer = pilih.next().charAt(0);
                            if (answer == 'y') {
                                doGauss.GaussEli(A, B);
                                System.out.println("Matriks setelah Gauss-elimination = ");
                                result.printMatrix(A);
                                result.solveSPLSave(A, B);
                            }
                            else {
                                doGauss.GaussEli(A, B);
                                System.out.println("Matriks setelah Gauss-elimination = ");
                                result.printMatrix(A);
                                doGauss.solveSPL(A, B);
                            }

                        }

                        break;

                    case 2:
                    if (sourceType == 1) {
                        int m, n;
                            char answer;
                            System.out.print("Masukkan jumlah baris : ");
                            n = spl.nextInt();
                            System.out.print("Masukan jumlah kolom : ");
                            m = spl.nextInt();
                            double[][] matriksSPL = new double[m][n];
                            double[] rightSide = new double[n];
                            currentMatriks.inputMatriks(matriksSPL, m, n);
                            currentMatriks.inputRightSide(rightSide, n);
                            System.out.println("Apakah hasil akan disimpan (y/n) ?");
                            answer = pilih.next().charAt(0);
                            if (answer == 'y') {
                                doGauss.GaussJordan(matriksSPL, rightSide);
                                System.out.println("Matriks setelah Gauss-Jordan = ");
                                result.printMatrix(matriksSPL);
                                result.solveSPLSave(matriksSPL, rightSide);
                            }
                            else {
                                doGauss.GaussJordan(matriksSPL, rightSide);
                                System.out.println("Matriks setelah Gauss-Jordan = ");
                                result.printMatrix(matriksSPL);
                                doGauss.solveSPL(matriksSPL, rightSide);
                            }

                    }

                    else {
                        int row, col;
                            char answer;
                            row = 0;
                            col = 0;
                            LoadFile loadfile = new LoadFile();
                            loadfile.LoadMatriks(col, row);
                            double[][] Aug = new double[col][row];
                            Aug = loadfile.LoadMatriks(col, row);
                            double[][] A = new double[col-1][row];
                            double[] B = new double[row];

                            A = currentMatriks.convertAugtoNormalMat(Aug);
                            B = currentMatriks.convertAugtoNormalRightSide(M);
                            System.out.println("Apakah hasil akan disimpan (y/n) ?");
                            answer = pilih.next().charAt(0);
                            if (answer == 'y') {
                                doGauss.GaussJordan(A, B);
                                System.out.println("Matriks setelah Gauss-Jordan = ");
                                result.printMatrix(A);
                                result.solveSPLSave(A, B);
                            }
                            else {
                                doGauss.GaussJordan(A, B);
                                System.out.println("Matriks setelah Gauss-Jordan = ");
                                result.printMatrix(A);
                                doGauss.solveSPL(A, B);
                            }

                    }

                        break;
                    case 3:
                    if (sourceType == 1){
                    int m, n;
                        char answer;
                        System.out.println("Jumlah kolom WAJIB berjumlah baris + 1 (Augmented Matrix)");
                        System.out.print("Masukkan jumlah baris : ");
                        n = spl.nextInt();
                        System.out.print("Masukan jumlah kolom : ");
                        m = spl.nextInt();
                        double[][] matriksSPL = new double[m][n];                            double[] rightSide = new double[n];
                        currentMatriks.inputMatriks(matriksSPL, m, n);
                        System.out.println("Apakah hasil akan disimpan (y/n) ?");
                        answer = pilih.next().charAt(0);
                        if (answer == 'y') {
                            doGauss.cramerSPL(matriksSPL);                                System.out.println("Matriks setelah Gauss-elimination = ");
                            result.printHasilPersamaan(doGauss.cramerSPL(matriksSPL));
                            result.SaveArrayIntoFile(doGauss.cramerSPL(matriksSPL));
                       }
                        else {
                            doGauss.cramerSPL(matriksSPL);
                            System.out.println("Solusinya : ");
                            result.printHasilPersamaan(doGauss.cramerSPL(matriksSPL));
                        }

                    }else{
                        int jmlkol=0, jmlbrs=0;
                        char answer;
                        load.LoadMatriks(jmlkol,jmlbrs);
                        double[][] matriksSPL = new double[jmlkol][jmlbrs];                      
                        matriksSPL = load.LoadMatriks(jmlkol,jmlbaris);
                        currentMatriks.inputMatriks(matriksSPL, jmlkol, jmlbrs);
                        System.out.println("Apakah hasil akan disimpan (y/n) ?");
                        answer = pilih.next().charAt(0);
                        if (answer == 'y') {
                            doGauss.cramerSPL(matriksSPL);                               
                            result.printHasilPersamaan(doGauss.cramerSPL(matriksSPL));
                            result.SaveArrayIntoFile(doGauss.cramerSPL(matriksSPL));
                       }
                        else {
                            doGauss.cramerSPL(matriksSPL);
                            System.out.println("Solusinya : ");
                            result.printHasilPersamaan(doGauss.cramerSPL(matriksSPL));
                        }
                    }
                        break;

                }

                break;

                
            case 2: // Determinan
                GetDeterminant findDet = new GetDeterminant();
                System.out.println("1. Metode eliminasi gauss");
                System.out.println("2. Metode Kofaktor");
                System.out.print("Mau nyari determinan pake apa bray ? ");
                Scanner det = new Scanner(System.in);
                int pilihdet = det.nextInt();
                System.out.println("Matriksnya mau darimana gan ?");
                System.out.println("1. Input Matriks");
                System.out.println("2. Baca dari File");
                sourceType = det.nextInt();

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
                                System.out.print(valDet);
                                result.SaveMatriksIntoFile(copyMatDet);
                                result.SaveDeterminantIntoFile(valDet);
                            }

                        }
                        else {
                            int row, col;
                            char answer;
                            double valDet;
                            row = 0;
                            col = 0;
                            LoadFile loadfile = new LoadFile();
                            loadfile.LoadMatriks(col, row);
                            double[][] Aug = new double[col][row];
                            Aug = loadfile.LoadMatriks(col, row);

                            valDet = findDet.gaussDeterminant(Aug);
                            System.out.println("Determinan dari Matriks diatas adalah = " + valDet);
                            System.out.println("");
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = pilih.next().charAt(0);
                            if (answer == 'y') {
                                System.out.print(valDet);
                                result.SaveMatriksIntoFile(copyMatDet);
                                result.SaveDeterminantIntoFile(valDet);
                            }
                            else {
                                System.out.print(valDet);
                            }


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

                    else {
                        int n, col, row;
                        double valDet;
                        char answer;

                        row = 0;
                        col = 0;
                        LoadFile loadfile = new LoadFile();
                        loadfile.LoadMatriks(col, row);
                        double[][] Aug = new double[col][row];
                        Aug = loadfile.LoadMatriks(col, row);

                        double[][] matriksDet = new double[n][n];
                        double[][] copyMatDet = new double[n][n];
                        copyMatDet = currentMatriks.CopyMatriks(Aug);
                        valDet = findDet.cofDeterminant(matriksDet);
                        System.out.println("Determinan dari Matriks diatas adalah = " + valDet);
                        System.out.println("");
                        System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                        answer = det.next().charAt(0);
                        if (answer == 'y') {
                            System.out.print(valDet);
                            result.SaveMatriksIntoFile(copyMatDet);
                            result.SaveDeterminantIntoFile(valDet);
                        }
                        else {
                            System.out.print(valDet);
                        }

                    }

                        break;

                }

                break;
            case 3:
                GetInverse inv = new GetInverse();
                int menu, input;
                System.out.println("1. Buat Invers dengan cara Adjoin");
                System.out.println("2. Buat Invers dengan cara Gauss Jordan");
                System.out.println("Pilih mana nih temanku ?");
                Scanner pilih = new Scanner(System.in);
                pilihmenu = pilih.nextInt();
                System.out.println("1. Input Matriks");
                System.out.println("2. Read Matriks dari File");
                pilihinput = pilih.nextInt();
                switch(pilihmenu) {
                    case 1:
                        if (pilihinput == 1) {
                            int n;
                            System.out.print("Masukkan N (Matriks N x N) : ");
                            n = cof.nextInt();
                            double[][] MInput = new double[n][n];
                            double[][] MInverse = new double[n][n];
                            currentMatriks.inputMatriks(MInput, n, n);
                            MInverse = inv.adjoinInverse(MInput);
                            System.out.println("Matriks Inversenya adalah : ");
                            result.printMatrix(MInverse);
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = pilih.next().charAt(0);
                            if(answer == 'y'){
                                result.SaveMatriksIntoFile(MInverse);
                            }
                        }
                        else if (pilihinput == 2) {
                            int jmlkol, jmlbrs;
                            jmlkol = 0; jmlbrs = 0;
                            load.LoadMatriks(jmlkol, jmlbrs);
                            double[][] MInput = new double[jmlkol][jmlbrs];
                            MInput = load.LoadMatriks(jmlkol, jmlbrs);
                            double[][] MInverse = new double[n][n];
                            MInverse = inv.adjoinInverse(MInput);
                            System.out.println("Matriks Inversenya adalah : ");
                            result.printMatrix(MInverse);
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = pilih.next().charAt(0);
                            if(answer == 'y'){
                                result.SaveMatriksIntoFile(MInverse);
                            }         
                        }
                    case 2:
                        if (pilihinput == 1) {
                            int n;
                            System.out.print("Masukkan N (Matriks N x N) : ");
                            n = cof.nextInt();
                            double[][] MInput = new double[n][n];
                            double[][] MInverse = new double[n][n];
                            currentMatriks.inputMatriks(MInput, n, n);
                            MInverse = inv.InverseGaussJordan(MInput);
                            System.out.println("Matriks Inversenya adalah : ");
                            result.printMatrix(MInverse);
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = pilih.next().charAt(0);
                            if(answer == 'y'){
                                result.SaveMatriksIntoFile(MInverse);
                            }
                        }
                        else if (pilihinput == 2) {
                            int jmlkol, jmlbrs;
                            jmlkol = 0; jmlbrs = 0;
                            load.LoadMatriks(jmlkol, jmlbrs);
                            double[][] MInput = new double[jmlkol][jmlbrs];
                            MInput = load.LoadMatriks(jmlkol, jmlbrs);
                            double[][] MInverse = new double[jmlkol][jmlbrs];
                            MInverse = inv.InverseGaussJordan(MInput);
                            System.out.println("Matriks Inversenya adalah : ");
                            result.printMatrix(MInverse);
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = pilih.next().charAt(0);
                            if(answer == 'y'){
                                result.SaveMatriksIntoFile(MInverse);
                            }
                        }
                }
                break;
            case 4: // Kofaktor
                GetCofactor myCof = new GetCofactor();
                int pilihMenu, pilihInput;
                System.out.println("1. Buat Matriks Kofaktor");
                System.out.println("2. Buat Matriks Entry");
                System.out.println("Mangga dipilih");
                Scanner cof = new Scanner(System.in);
                pilihMenu = cof.nextInt();
                System.out.println("1. Input Matriks");
                System.out.println("2. Read Matriks dari File");
                pilihInput = cof.nextInt();
                switch (pilihMenu){
                    case 1:
                        if(pilihInput == 1){
                            int n;
                            char answer;
                            System.out.print("Masukkan N (Matriks N x N) : ");
                            n = cof.nextInt();
                            double[][] MInput = new double[n][n];
                            double[][] MCof = new double[n][n];
                            currentMatriks.inputMatriks(MInput, n, n);
                            MCof = myCof.makeCofMatrix(MInput);
                            System.out.println("Matriks kofaktornya adalah : ");
                            result.printMatrix(MCof);
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = cof.next().charAt(0);
                            if(answer == 'y'){
                                result.SaveMatriksIntoFile(MCof);
                            }


                        }else{
                            int jmlkol, jmlbrs;
                            char answer;
                            jmlkol = 0; jmlbrs = 0;
                            load.LoadMatriks(jmlkol, jmlbrs);
                            double[][] MInput = new double[jmlkol][jmlbrs];
                            MInput = load.LoadMatriks(jmlkol, jmlbrs);
                            double[][] MCof = new double[jmlkol][jmlbrs];
                            MCof = myCof.makeCofMatrix(MInput);
                            System.out.println("Matriks Kofaktornya adalah : ");
                            result.printMatrix(MCof);
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = pilih.next().charAt(0);
                            if(answer == 'y'){
                                result.SaveMatriksIntoFile(MCof);
                            }
                        }
                        break;
                    case 2:
                        if(pilihInput == 1){
                            int n;
                            int col,row;
                            char answer;
                            System.out.print("Masukkan N (Matriks N x N) : ");
                            n = cof.nextInt();
                            double[][] MInput = new double[n][n];
                            double[][] MEntry = new double[n-1][n-1];
                            currentMatriks.inputMatriks(MInput, n, n);
                            System.out.print("Masukkan baris dan kolom yang ingin dihilangkan :");
                            col = cof.nextInt();
                            row = cof.nextInt();
                            MEntry = myCof.makeEntryMatrix(MInput, col, row);
                            System.out.println("Matriks Entry-nya adalah : ");
                            result.printMatrix(MEntry);
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = cof.next().charAt(0);
                            if(answer == 'y'){
                                result.SaveMatriksIntoFile(MEntry);
                            }


                        }else{
                            int jmlkol, jmlbrs;
                            char answer;
                            jmlkol = 0; jmlbrs = 0;
                            load.LoadMatriks(jmlkol, jmlbrs);
                            double[][] MInput = new double[jmlkol][jmlbrs];
                            MInput = load.LoadMatriks(jmlkol, jmlbrs);
                            double[][] MEntry = new double[jmlkol-1][jmlbrs-1];
                            System.out.print("Masukkan baris dan kolom yang ingin dihilangkan :");
                            jmlkol = cof.nextInt();
                            jmlbrs = cof.nextInt();
                            MEntry = myCof.makeEntryMatrix(MInput, jmlkol, jmlbrs);
                            System.out.println("Matriks Entry-nya adalah : ");
                            result.printMatrix(MEntry);
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = pilih.next().charAt(0);
                            if(answer == 'y'){
                                result.SaveMatriksIntoFile(MEntry);
                            }
                        }
                        break;
                }
                break;
            case 5://cofactor
                GetCofactor factor = new GetCofactor();
                int nomor, cara;
                System.out.println("1. Buat Matriks Adjoin");
                System.out.println("2. Buat Matriks Cofactor");
                Scanner baca = new Scanner(System.in);
                nomor = baca.nextInt();
                System.out.println("1. Input Matriks");
                System.out.println("2. Read Matriks dari File");
                cara = baca.nextInt();
                switch (nomor){
                    case 1:
                        if(cara == 1){
                            int n;
                            char answer;
                            System.out.print("Masukkan N (Matriks N x N) : ");
                            n = cof.nextInt();
                            double[][] MInput = new double[n][n];
                            double[][] MAdj = new double[n][n];
                            currentMatriks.inputMatriks(MInput, n, n);
                            MAdj = factor.makeAdjMatrix(MInput);
                            System.out.println("Matriks adjoinnya adalah : ");
                            result.printMatrix(MAdj);
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = cof.next().charAt(0);
                            if(answer == 'y'){
                                result.SaveMatriksIntoFile(MAdj);
                            }
                        }else{
                            int jmlkol, jmlbrs;
                            char answer;
                            jmlkol = 0; jmlbrs = 0;
                            load.LoadMatriks(jmlkol, jmlbrs);
                            double[][] MInput = new double[jmlkol][jmlbrs];
                            MInput = load.LoadMatriks(jmlkol, jmlbrs);
                            double[][] MAdj = new double[jmlkol][jmlbrs];
                            MAdj = factor.makeAdjMatrix(MInput);
                            System.out.println("Matriks Kofaktornya adalah : ");
                            result.printMatrix(MAdj);
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = pilih.next().charAt(0);
                            if(answer == 'y'){
                                result.SaveMatriksIntoFile(MAdj);
                            }
                        }    
                        break;
                    case 2:
                        if(cara == 1){
                            int n;
                            char answer;
                            System.out.print("Masukkan N (Matriks N x N) : ");
                            n = cof.nextInt();
                            double[][] MInput = new double[n][n];
                            double[][] MCof = new double[n][n];
                            currentMatriks.inputMatriks(MInput, n, n);
                            MCof = factor.makeCofMatrix(MInput);
                            System.out.println("Matriks adjoinnya adalah : ");
                            result.printMatrix(MCof);
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = cof.next().charAt(0);
                            if(answer == 'y'){
                                result.SaveMatriksIntoFile(MCof);
                            }
                        }else{
                            int jmlkol, jmlbrs;
                            char answer;
                            jmlkol = 0; jmlbrs = 0;
                            load.LoadMatriks(jmlkol, jmlbrs);
                            double[][] MInput = new double[jmlkol][jmlbrs];
                            MInput = load.LoadMatriks(jmlkol, jmlbrs);
                            double[][] MCof = new double[jmlkol][jmlbrs];
                            MCof = factor.makeAdjMatrix(MInput);
                            System.out.println("Matriks Kofaktornya adalah : ");
                            result.printMatrix(MCof);
                            System.out.print("Hasilnya mau disimpen bray (y/n) ? ");
                            answer = pilih.next().charAt(0);
                            if(answer == 'y'){
                                result.SaveMatriksIntoFile(MCof);
                            }
                        }    
                        break;
                break;
            case 6:

                // Interpolasi, didalam method2nya sudah ada tawaran untuk safe file
                    int n;
                    Interpolasi getInter = new Interpolasi();
                    int jumlahInterpolasi;
                    Scanner inputInter = new Scanner(System.in);
                    n = inputInter.nextInt();
                    double[][] persamaanInter = new double[n][n];
                    double[] hasilInter = new double[n];
                    currentMatriks.inputMatriksInterpolasi(persamaanInter, hasilInter, n);
                    getInter.solveInterpolasi(persamaanInter, hasilInter);
                    getInter.approx(persamaanInter, hasilInter);
                
                break;
            case 7:

                break; // Yeah, just like this

            case 9999:
                System.out.println("Cheat Activated!");
                System.out.println("Follow IG Kami : ");
                System.out.println("Bagas - @bagas.setyo");
                System.out.println("Radhin - @radhinghaida");
                System.out.println("Rafi - @rafi.adyatma");
                System.out.println("");
                break;
            default:
                System.out.println("Menu yang anda pilih tidak sesuai bray!");
                    }
                }
    }
}
