package com.example.ulanganfirosyanammar11;

import java.util.ArrayList;

public class dataMakanan {
    private static String [] namaMakanan = {
        "Lontong Balap",
        "Rujak Cingur",
        "Nasi Krawu",
        "Ayam Lodho",
        "Petulo",
        "Nasi Rawon",
        "Soto Lamongan",
        "Tahu Tek"
    };

    private static String [] Deskripsi ={
        "Lontong balap adalah makanan khas Indonesia yang merupakan ciri khas kota Surabaya di Jawa Timur. Makanan ini terdiri dari lontong, taoge, tahu goreng, lentho, bawang goreng, kecap, dan sambal. ",
        "Rujak cingur adalah salah satu makanan tradisional yang mudah ditemukan di daerah Jawa Timur, terutama di daerah asalnya Surabaya. Dalam bahasa Jawa kata cingur berarti mulut, hal ini merujuk pada bahan irisan mulut atau moncong sapi yang direbus dan dicampurkan ke dalam hidangan.",
        "Nasi krawu merupakan makanan khas dari daerah Gresik, Jawa Timur. Cirinya adalah nasinya yang pulen dan disajikan dengan daun pisang. Lauknya dapat berupa sayatan daging sapi, semur daging, jeroan sapi, sambal petis dan serundeng. Sambal terasi yang disajikan bersama dengan nasi krawu memiliki rasa pedas yang khas.",
        "Ayam yang digunakan untuk membuat ayam lodho biasanya ayam kampung atau ayam pejantan. Kemudian, ayam dibakar hingga kulitnya gosong setelah itu disiram ke dalam kuah santan yang pedas. Cita rasa gosong kulit ayam ini yang membuat lodho terasa istimewa.",
        "perbedaan paling mendasar ialah pada perbandingan santan yang menjadi bahan utama petulo dan putu mayang. Meski sama-sama memakai tepung beras, bentuk juga sedikit berbeda. Kue tradisional khas Jawa Timur ini seperti rol rambut, sementara putu mayang bentuknya lebih pipih.",
        "Rawon adalah masakan Indonesia berupa sup daging berkuah hitam dengan campuran bumbu khas yang menggunakan kluwek. Rawon, meskipun dikenal sebagai masakan khas Jawa Timur, dikenal pula oleh masyarakat Jawa Tengah sebelah timur.",
        "Soto, sroto, sauto, tauto, atau coto adalah makanan khas Indonesia seperti sop yang terbuat dari kaldu daging dan sayuran. Daging yang paling sering digunakan adalah daging sapi dan ayam, tetapi ada pula yang menggunakan daging babi atau kambing.",
        "Tahu tek adalah salah satu masakan khas kota Lamongan. Tahu tek terdiri atas tahu goreng setengah matang dan lontong yang dipotong kecil-kecil dengan alat gunting dan garpu untuk memegang tahu atau lontong, telur, kentang goreng, sedikit taoge, dan irisan ketimun dipotong kecil-panjang (seperti acar), lalu setelah disiram dengan saus kacang dengan campuran petis di atasnya, ditaburkan kerupuk udang yang bentuknya kecil dengan diameter sekitar 3 cm"
    };
    private static int [] Image = {
        R.drawable.lontongresing,
        R.drawable.rujakcingur,
        R.drawable.segokrawu,
        R.drawable.ayamlodho,
        R.drawable.petulo,
        R.drawable.rawon,
        R.drawable.sotolamongan,
        R.drawable.tahutek

    };

    static ArrayList<Makanan> getListData(){
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position <namaMakanan.length; position++){
            Makanan makanan = new Makanan();
            makanan.setName(namaMakanan[position]);
            makanan.setDetail(Deskripsi[position]);
            makanan.setPhoto(Image[position]);
            list.add(makanan);
        }
        return list;
    }
}



