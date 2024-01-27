import java.util.*;
public class Main {
    public static void main(String[] args) {
/*
Sezar şifreleme yöntemi antik yunan döneminde yaygın olarak kullanılan bir şifreleme türüdür.
Bizde programımızda bu şifreleme yönteminin programını yapacaz
Bu şifrelemede açık verilen  metin belirli bir anahtar sayı kadar aynı tür içerisinde artılır.
örnek : AbC 7 metni anahtar = 3 olacak şekilde şifrelenirse   "DeF 0" olur
boşluk karakteri değiştirlmeden yazılır
 */
        /*
Boşluk karakterinin ASCII karşılığı = 32
Büyük harflerin (A-Z) ASCII karşılığı [65-90] arasındadır.
Küçük harflerin (a-z) ASCII karşılığı [97-122] arasındadır.
0-9 rakamlarının ASCII karşılığı [48-57] arasındadır.
   */
        Scanner klavye = new Scanner(System.in);
        System.out.println("Lütfen açık metni giriniz");
        String metin = klavye.nextLine();

        // anahtar değeri 0 dan büyük olmalı ve 10 dan küçük olmalıdır.
        int anahtar;
        do {
            System.out.println("Lütfen anahtar değerini giriniz");
            anahtar = klavye.nextInt();
        } while (anahtar < 1 || anahtar>9);
        sezarsifreoluşturma(metin, anahtar);
    }

    public static void sezarsifreoluşturma(String metin, int anahtar) {

        // Burda char tipine dönüştürdük. Sonrasında ise int dizisi ile ascı kodlarına dönüştürdük.
        char[] sifrelimetin = metin.toCharArray();
        int [] ascı=new int[sifrelimetin.length];

        for (int i=0;i<ascı.length;i++){
        ascı[i]=(int) sifrelimetin[i];
        }

        // Boşluk karakteri varsa değişilmeyecek
        for (int i =0;i<ascı.length;i++){
        if (ascı[i]==32){
            sifrelimetin[i]=' ';
        }

        /* ascı kodu o karakterin numarası aralığındamı diye kontrol yaptık eğer aralıktaysa
        direk chara cevirdik . Aralıkta olmayan değerler içinde ascı de aralığı verilen numaraların farkından
        1 çıkartarak aralığa soktuk
        örn : ascı kodu = 57   anahtar = 6   yeni ascı kodu 63 ama aralıkta değil o yüzden
        57-(57-46)-1 işlemini yaparak aralığa soktuk   parantez içi ascı tablodaki aralık değerleri
        en sonunda ascı dizisini chara cevirerek sifrelimetin dizisine aktardık
          */

        else if (ascı[i]>47&&ascı[i]<58){
            ascı[i]+=anahtar;
            if  (ascı[i]>47&&ascı[i]<58){
                sifrelimetin[i]=(char)ascı[i];
            }
            else {
                ascı[i]-=10;
                sifrelimetin[i]=(char)ascı[i];
            }
        }
        else if (ascı[i]>96&&ascı[i]<123){
            ascı[i]+=anahtar;
            if (ascı[i]>93&&ascı[i]<123){
                sifrelimetin[i]=(char) ascı[i];
            }
            else {
                ascı[i]-=26;
                sifrelimetin[i]=(char)ascı[i];
            }
        }
        else if (ascı[i]>64&&ascı[i]<91){
            ascı[i]+=anahtar;
            if (ascı[i]>64&&ascı[i]<91){
               sifrelimetin[i]=(char) ascı[i];
            }
            else {
                ascı[i]-=26;
                sifrelimetin[i]=(char) ascı[i];
            }
        }
        }
        System.out.println("Orjinal metin :"+metin);
        System.out.println("Anahar uzunluğu : "+anahtar);
        System.out.println("Sezar şifreleme yöntemi ile luşturulmuş şifreli metin oluşturuluyor ...");
        for (char a :sifrelimetin){
            System.out.print(a);
        }
    }
}