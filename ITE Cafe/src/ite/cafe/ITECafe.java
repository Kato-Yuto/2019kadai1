package ite.cafe;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ITECafe {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int inputNum = 0;//入力された商品番号
        int goukei = 0;//合計金額
        int ans = (2);//選択
        int sc;//数量

        //人数
        while (true) {
            try {
                System.out.println("人数を入力してください");
                String inputhito;
                inputhito = scan.next();
                inputNum = Integer.parseInt(inputhito);

                if (inputNum <=0) {
                    System.out.println("人数が確認できません。 もう一度人数を入力してください。");
                    inputhito = scan.next();
                    inputNum = Integer.parseInt(inputhito);
                    break;

                } else {
                    System.out.println("人数は" + inputNum + "人です" + "\n");
                    break;
                }

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("【入力エラー：数字を入力してください】");

            }
        }

        //日付
        Date aa = new Date();
        SimpleDateFormat bb = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
        System.out.println(bb.format(aa));

        bb.applyPattern("yyyy/MM/dd/EE\n");
        System.out.println(bb.format(aa));

        //準備
        //ドリンク
        Item hotCoffee = new Item(1, "ホットコーヒー", 280); //3つの情報
        Item tea = new Item(2, "紅茶", 260); //3つの情報
        Item iceCoffee = new Item(3, "アイスコーヒー", 200);
        Item iceTea = new Item(4, "アイスティー", 280);

        //スイーツ
        Item shortCake = new Item(5, "ショートケーキ", 280);
        Item tizeCake = new Item(6, "チーズケーキ", 400);
        Item chokoCake = new Item(7, "チョコレートケーキ", 450);
        Item chokoBananaPahue = new Item(8, "チョコバナナパフェ", 390);
        Item itigoPahue = new Item(9, "イチゴパフェ", 390);

        //軽食
        Item mitopasuta = new Item(10, "ミートパスタ", 650);
        Item mixPizza = new Item(11, "ミックスピザ", 700);

        //パン
        Item kurowasan = new Item(12, "クロワッサン", 180);
        Item tosuto = new Item(13, "トーストサンド", 200);
        Item hurentiTosuto = new Item(14, "フレンチトースト", 210);

        //配列メニュー
        Item[] items = new Item[14];
        items[0] = hotCoffee;
        items[1] = tea;
        items[2] = iceCoffee;
        items[3] = iceTea;
        items[4] = shortCake;
        items[5] = tizeCake;
        items[6] = chokoCake;
        items[7] = chokoBananaPahue;
        items[8] = itigoPahue;
        items[9] = mitopasuta;
        items[10] = mixPizza;
        items[11] = kurowasan;
        items[12] = tosuto;
        items[13] = hurentiTosuto;

        while (true) {

            System.out.println("ITECafe　メニュー　" + "\n");

            //メニュー一覧
            //ドリンク
            System.out.println("～ドリンク～");
            System.out.println(hotCoffee.getNo() + ":" + hotCoffee.getName());
            System.out.println(tea.getNo() + ":" + tea.getName());
            System.out.println(iceCoffee.getNo() + ":" + iceCoffee.getName());
            System.out.println(iceTea.getNo() + ":" + iceTea.getName() + "\n");

            //スイーツ
            System.out.println("～スイーツ～");
            System.out.println(shortCake.getNo() + ":" + shortCake.getName());
            System.out.println(tizeCake.getNo() + ":" + tizeCake.getName());
            System.out.println(chokoCake.getNo() + ":" + chokoCake.getName());
            System.out.println(chokoBananaPahue.getNo() + ":" + chokoBananaPahue.getName());
            System.out.println(itigoPahue.getNo() + ":" + itigoPahue.getName() + "\n");

            //軽食
            System.out.println("～サイドメニュー～");
            System.out.println(mitopasuta.getNo() + ":" + mitopasuta.getName());
            System.out.println(mixPizza.getNo() + ":" + mixPizza.getName() + "\n");

            //パン
            System.out.println("～パン～");
            System.out.println(kurowasan.getNo() + ":" + kurowasan.getName());
            System.out.println(tosuto.getNo() + ":" + tosuto.getName());
            System.out.println(hurentiTosuto.getNo() + ":" + hurentiTosuto.getName() + "\n");

            //商品番号を入力
            System.out.println("商品番号を入力してください");
            while (true) {
                try {
                    String inputStr;
                    inputStr = scan.next();
                    inputNum = Integer.parseInt(inputStr);

                    System.out.println(
                            items[inputNum - 1].getNo() + ":" + items[inputNum - 1].getName()
                            + items[inputNum - 1].getPrice() + "円が入力されました" + "\n");
                    break;
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("【入力エラー：数字を入力してください】");
                }
            }

            //商品数量
            System.out.println("数量を入力してください");
            while (true) {
                try {
                    //数量入力
                    String inputsc;
                    inputsc = scan.next();
                    sc = Integer.parseInt(inputsc);
                    goukei += items[inputNum - 1].getPrice() * sc;

                    if (sc <= 0) {
                        System.out.println("一個数以上の入力をしてください");
                    } else {
                        System.out.println("合計金額は" + goukei + "円です" + "\n");
                        break;
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("【入力エラー：数字を入力してください】");
                }

            }

            //入力は終了か？
            //終了ならループを抜ける　break;
            System.out.println("続けますか？");
            System.out.println("１：続ける　　２：終了します  ０：やり直し" + "\n");

            try {
                String inputStr;
                inputStr = scan.next();
                ans = Integer.parseInt(inputStr);

                switch (ans) {
                    case 1://続ける
                        continue;

                    case 0://やり直し
                        goukei = 0;
                        continue;

                    case 2://終了
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println("【入力エラー：数字を入力してください】");
            }
            if (ans >= 0 && ans <= 2) {
                break;

            }

        }

        int flg = -1;
        int goukei2 = goukei;
        String inputreji = null;

        //税金込みの合計金額を出す
        while (flg == -1) {
            goukei = goukei2;

            double zeikin = 1.08;
            goukei *= zeikin;
            if (goukei >= 0) {
                System.out.println("合計は" + goukei + "円です" + "\n");
                System.out.println("金額を入力");
            } else {
                System.out.println("タダ");
            }

            //お金預かる
            inputreji = scan.next();
            inputNum = Integer.parseInt(inputreji);

            if (inputNum >= goukei) {
                flg = 0;
            }
        }

        System.out.println(inputreji + "円、お預かりいたします" + "\n");

        //合計ー金額
        int reji = Integer.parseInt(inputreji);

        System.out.println(reji - goukei + "円のお釣りになります" + "\n");
        System.out.println("ありがとうございました");

    }
}
