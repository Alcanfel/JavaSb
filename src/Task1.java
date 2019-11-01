class Task1{
    public static void main(String[] args){
        // Исходные данные
        String[] arrayCodeMileage = {"Z11-100", "Z12-150", "Z13-120", "Z11-80", "Z12-50", "Z13-40", "Z11-200", "Z12-0", "Z13-10", "Z11-170"};
        String[] arrayTypeFuel = {"Z11-46.10","Z12-47.50","Z13-48.90"};
        String[] arrayDifferentFuel = {"Z11-12.5","Z12-12","Z13-11.5"};

        // Получаем массив сгруппированных по типу авто, сумму расходов за ГСМ, где расход топлива у всех одинаковый 15л на 100км
        String[] arrayGroupVariantOne = groupByCostGsm(arrayCodeMileage , arrayTypeFuel);

        System.out.println("\n---Расход топлива одинаковый---");
        for (String s : arrayGroupVariantOne) {
            System.out.println(s);
        }
        System.out.format("1) Общая стоимость расходов: %f\n",sumTotalGsm(arrayGroupVariantOne));
        System.out.format("2) Тип авто имеющий наибольшую стоимость расходов: %s\n",typeAutoMax(arrayGroupVariantOne));
        System.out.format("2) Тип авто имеющий наименьшую стоимость расходов: %s\n",typeAutoMin(arrayGroupVariantOne));

        // Получаем массив сгруппированных по типу авто, сумму расходов за ГСМ, где расход топлива разный
        String[] arrayGroupVariantTwo = groupByCostGsm(arrayCodeMileage, arrayTypeFuel, arrayDifferentFuel);
        System.out.println("\n---Расход топлива разный---");
        for (String s : arrayGroupVariantTwo) {
            System.out.println(s);
        }

        System.out.format("1) Общая стоимость расходов: %f\n",sumTotalGsm(arrayGroupVariantTwo));
        System.out.format("2) Тип авто имеющий наибольшую стоимость расходов: %s\n",typeAutoMax(arrayGroupVariantTwo));
        System.out.format("2) Тип авто имеющий наименьшую стоимость расходов: %s\n",typeAutoMin(arrayGroupVariantTwo));



    }
    // Осуществил перегрузку метода groupByCostGsm (возвращает массив сгруппированных по типу авто, сумму расходов за ГСМ),
    // не передаем 3 параметр - расход одинаковый,
    // передаем 3 параметр - расход разный
    public static String[] groupByCostGsm(String[] a, String[] b){
        StringBuilder result = new StringBuilder();
        StringBuilder result_code = new StringBuilder();
        float result_summa = 0;

        for(int i = 0; i < a.length; i++){ //Пробегаемся по массиву исходных данных код-пробег
            String code = a[i].split("-")[0]; // Вытаскиваем код
            float mileage = Float.parseFloat(a[i].split("-")[1]); //Вытаскиваем пробег
            //if (mileage == 0) continue; // Если пробег нулевой, то переходим к след. итерации, т.к. нет смысла считать расход
            if (result.indexOf(code) == -1) result_code.append(code).append("#"); //Фомируем массив уникальных кодов, чтобы далее использовать для группировки кодов со стоимостью
            for(int j = 0; j < b.length; j++){ //пробегаемся по цене топлива код-цена
                String code_2 = b[j].split("-")[0]; //Вытаскиваем код
                float price = Float.parseFloat(b[j].split("-")[1]); // Вытаксиеваем цену
                if (code.equals(code_2)){ // Если коды совпадают
                    result_summa = ((mileage/100) * 15) * price; //Высчитывам сумму за ГСМ
                    result.append(code).append("-").append(result_summa);	//Добавляем в общую строку
                }
            }
            result.append("#");
        }
        String[] itog_z = String.valueOf(result_code).split("#");
        String[] itog = String.valueOf(result).split("#");
        StringBuilder result_gsm = new StringBuilder();
        for(int i = 0; i < itog_z.length; i++){
            result_gsm.append(itog_z[i]);
            float summa = 0;
            for(int j = 0; j < itog.length; j++){
                String code = itog[j].split("-")[0]; // Вытаскиваем код
                float price_one = Float.parseFloat(itog[j].split("-")[1]); //Вытаскиваем сумму
                if (itog_z[i].equals(code)){
                    summa+=price_one;
                }
            }
            result_gsm.append("=").append(summa);
            result_gsm.append("#");
        }
        return result_gsm.toString().split("#");
    }


    public static String[] groupByCostGsm(String[] a, String[] b, String[] c){
        StringBuilder result = new StringBuilder();
        StringBuilder result_code = new StringBuilder();
        float result_summa = 0;

        for(int i = 0; i < a.length; i++){ //Пробегаемся по массиву исходных данных код-пробег
            String code = a[i].split("-")[0]; // Вытаскиваем код
            float mileage = Float.parseFloat(a[i].split("-")[1]); //Вытаскиваем пробег
            //if (mileage == 0) continue; // Если пробег нулевой, то переходим к след. итерации, т.к. нет смысла считать расход
            if (result.indexOf(code) == -1) result_code.append(code).append("#"); //Фомируем массив уникальных кодов, чтобы далее использовать для группировки кодов со стоимостью
            for(int j = 0; j < b.length; j++){ //пробегаемся по цене топлива код-цена
                String code_2 = b[j].split("-")[0]; //Вытаскиваем код
                float price = Float.parseFloat(b[j].split("-")[1]); // Вытаксиеваем цену
                if (code.equals(code_2)){ // Если коды совпадают
                    for(int z = 0; z < c.length; z++){
                        String code_3 = c[z].split("-")[0];
                        float fuel = Float.parseFloat(c[z].split("-")[1]);
                        if (code_2.equals(code_3)){
                            result_summa = ((mileage/100) * fuel) * price;
                            result.append(code).append("-").append(result_summa);
                        }
                    }
                }
            }
            result.append("#");
        }
        String[] itog_z = String.valueOf(result_code).split("#");
        String[] itog = String.valueOf(result).split("#");
        StringBuilder result_gsm = new StringBuilder();
        for(int i = 0; i < itog_z.length; i++){
            result_gsm.append(itog_z[i]);
            float summa = 0;
            for(int j = 0; j < itog.length; j++){
                String code = itog[j].split("-")[0]; // Вытаскиваем код
                float price_one = Float.parseFloat(itog[j].split("-")[1]); //Вытаскиваем сумму
                if (itog_z[i].equals(code)){
                    summa+=price_one;
                }
            }
            result_gsm.append("=").append(summa);
            result_gsm.append("#");
        }
        return result_gsm.toString().split("#");
    }

    public static float sumTotalGsm(String[] s){
        float result = 0;
        for (int i = 0; i < s.length; i++){
            result += Float.parseFloat(s[i].split("=")[1]);
        }
        return result;
    }

    public static String typeAutoMax(String[] s){
        String auto_result = new String(String.valueOf(s[0].split("=")[0]));
        float summa_result = Float.parseFloat(s[0].split("=")[1]);
        for (int i = 0; i < s.length; i++){
            if (summa_result < Float.parseFloat(s[i].split("=")[1])) {
                auto_result = String.valueOf(s[i].split("=")[0]);
                summa_result = Float.parseFloat(s[i].split("=")[1]);
            }
        }
        return auto_result;
    }

    public static String typeAutoMin(String[] s){
        String auto_result = new String(String.valueOf(s[0].split("=")[0]));
        float summa_result = Float.parseFloat(s[0].split("=")[1]);
        for (int i = 0; i < s.length; i++){
            if (summa_result > Float.parseFloat(s[i].split("=")[1])) {
                auto_result = String.valueOf(s[i].split("=")[0]);
                summa_result = Float.parseFloat(s[i].split("=")[1]);
            }
        }
        return auto_result;
    }
}
