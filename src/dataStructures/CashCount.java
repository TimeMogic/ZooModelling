package dataStructures;

public class CashCount implements ICashCount{

    private int note20;
    private int note10;
    private int note5;
    private int coin2;
    private int coin1;
    private int coin50p;
    private int coin20p;
    private int coin10p;

    public CashCount() {
    }
    public CashCount(ICashCount cash) {
        this.note20 = cash.getNrNotes_20pounds();
        this.note10 = cash.getNrNotes_10pounds();
        this.note5 = cash.getNrNotes_5pounds();
        this.coin2 = cash.getNrCoins_2pounds();
        this.coin1 = cash.getNrCoins_1pound();
        this.coin50p = cash.getNrCoins_50p();
        this.coin20p = cash.getNrCoins_20p();
        this.coin10p = cash.getNrCoins_10p();
    }

    public int getValuePence() {
        int value = 0;
        value += 2000 * this.note20;
        value += 1000 * this.note10;
        value += 500 * this.note5;
        value += 200 * this.coin2;
        value += 100 * this.coin1;
        value += 50 * this.coin50p;
        value += 20 * this.coin20p;
        value += 10 * this.coin10p;
        return value;
    }

    public void addCash(ICashCount cash) {
        this.note20 += cash.getNrNotes_20pounds();
        this.note10 += cash.getNrNotes_10pounds();
        this.note5 += cash.getNrNotes_5pounds();
        this.coin2 += cash.getNrCoins_2pounds();
        this.coin1 += cash.getNrCoins_1pound();
        this.coin50p += cash.getNrCoins_50p();
        this.coin20p += cash.getNrCoins_20p();
        this.coin10p += cash.getNrCoins_10p();
    }

    public void subCash(ICashCount cash) {
        this.note20 -= cash.getNrNotes_20pounds();
        this.note10 -= cash.getNrNotes_10pounds();
        this.note5 -= cash.getNrNotes_5pounds();
        this.coin2 -= cash.getNrCoins_2pounds();
        this.coin1 -= cash.getNrCoins_1pound();
        this.coin50p -= cash.getNrCoins_50p();
        this.coin20p -= cash.getNrCoins_20p();
        this.coin10p -= cash.getNrCoins_10p();
    }

    public ICashCount findChange(int change) {
        ICashCount changeFound = new CashCount();
            int amount = change;
            if ((amount / 2000) < this.note20) {
                changeFound.setNrNotes_20pounds(amount / 2000);
                amount %= 2000;
            } else {
                changeFound.setNrNotes_20pounds(this.note20);
                amount -= this.note20 * 2000;
            }
            if ((amount / 1000) < this.note10) {
                changeFound.setNrNotes_10pounds(amount / 1000);
                amount %= 1000;
            } else {
                changeFound.setNrNotes_10pounds(this.note10);
                amount -= this.note10 * 1000;
            }
            if ((amount / 500) < this.note5) {
                changeFound.setNrNotes_5pounds(amount / 500);
                amount %= 500;
            } else {
                changeFound.setNrNotes_5pounds(this.note5);
                amount -= this.note5 * 500;
            }
            if ((amount / 200) < this.coin2) {
                changeFound.setNrCoins_2pounds(amount / 200);
                amount %= 200;
            } else {
                changeFound.setNrCoins_2pounds(this.coin2);
                amount -= this.coin2 * 200;
            }
            if ((amount / 100) < this.coin1) {
                changeFound.setNrCoins_1pound(amount / 100);
                amount %= 100;
            } else {
                changeFound.setNrCoins_1pound(this.coin1);
                amount -= this.coin1 * 100;
            }
            if ((amount / 50) < this.coin50p) {
                changeFound.setNrCoins_50p(amount / 50);
                amount %= 50;
            } else {
                changeFound.setNrCoins_50p(this.coin50p);
                amount -= this.coin50p * 50;
            }
            if ((amount / 20) < this.coin20p) {
                changeFound.setNrCoins_20p(amount / 20);
                amount %= 20;
            } else {
                changeFound.setNrCoins_20p(this.coin20p);
                amount -= this.coin20p * 20;
            }
            if ((amount / 10) <= this.coin10p) {
                changeFound.setNrCoins_10p(amount / 10);
                return changeFound;
            } else {    //not enough change
                return null;
            }

    }

    @Override
    public void setNrNotes_20pounds(int noteCount) {
        this.note20 = noteCount;
    }

    @Override
    public void setNrNotes_10pounds(int noteCount) {
        this.note10 = noteCount;
    }

    @Override
    public void setNrNotes_5pounds(int noteCount) {
        this.note5 = noteCount;
    }

    @Override
    public void setNrCoins_2pounds(int coinCount) {
        this.coin2 = coinCount;
    }

    @Override
    public void setNrCoins_1pound(int coinCount) {
        this.coin1 = coinCount;
    }

    @Override
    public void setNrCoins_50p(int coinCount) {
        this.coin50p = coinCount;
    }

    @Override
    public void setNrCoins_20p(int coinCount) {
        this.coin20p = coinCount;
    }

    @Override
    public void setNrCoins_10p(int coinCount) {
        this.coin10p = coinCount;
    }

    @Override
    public int getNrNotes_20pounds() {
        return this.note20;
    }

    @Override
    public int getNrNotes_10pounds() {
        return this.note10;
    }

    @Override
    public int getNrNotes_5pounds() {
        return this.note5;
    }

    @Override
    public int getNrCoins_2pounds() {
        return this.coin2;
    }

    @Override
    public int getNrCoins_1pound() {
        return this.coin1;
    }

    @Override
    public int getNrCoins_50p() {
        return this.coin50p;
    }

    @Override
    public int getNrCoins_20p() {
        return this.coin20p;
    }

    @Override
    public int getNrCoins_10p() {
        return this.coin10p;
    }
}
