class Sort {
    public static void main(String[] args) {
        int[] num;
        int qty = 0;
        int min = 0;
        int max = 0;

        if (args.length < 1) {
            err();
        }
        if (args[0].equals("random")) {
            try {
                qty = Integer.parseInt(args[1]);
                min = Integer.parseInt(args[2]);
                max = Integer.parseInt(args[3]);
            } catch (NumberFormatException e) {
                err();
            }

            num = new int[qty];
            for (int i = 0; i < qty; i++) {
                num[i] = (int)Math.floor(Math.random() * (max - min + 1)) + min;
            }
        } else {
            num = new int[args.length];
            try {
                for (int i = 0; i < args.length; i++) {
                    num[i] = Integer.parseInt(args[i]);
                }
            } catch (NumberFormatException e) {
                err();
            }
        }

        System.out.println("入力された配列");
        list(num);

        sort(num, 0, num.length - 1);

        System.out.println("ソートされた配列");
        list(num);
        System.exit(0);
    }

    private static void sort(int[] num, int begin, int end) {
        int pvt = num[pivot(num, begin, end)];
        int l = begin;
        int r = end;
        int w;

        while (true) {
            while (num[l] < pvt) l++;
            while (pvt < num[r]) r--;
            if (l >= r) break;
            w = num[l];
            num[l] = num[r];
            num[r] = w;
            l++;
            r--;
        }

        if (l - begin >= 2) {
            sort(num, begin, l - 1);
        }
        if (end - r >= 2) {
            sort(num, r + 1, end);
        }
    }

    private static int pivot(int[] num, int begin, int end) {
        int mid = (begin + end) / 2;
        int min, max, pvt;

        if (num[begin] < num[end]) {
            min = begin;
            max = end;
        } else {
            min = end;
            max = begin;
        }
        if (num[mid] < num[min]) {
            pvt = min;
        } else if (num[max] < num[mid]) {
            pvt = max;
        } else {
            pvt = mid;
        }

        return pvt;
    }

    private static void err() {
        System.out.println("Usage : java Sort [data1] [data2] [data3]... or java Sort random 個数 最小値 最大値");
        System.exit(0);
    }

    private static void list(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}