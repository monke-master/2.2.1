public class Fraction{
    private int numerator;
    private int denominator = 1;

    public Fraction(int numerator, int denominator){
        if(denominator == 0){
            System.out.println("Denominator can't be zero. Choose another one.");
            return;
        }
        this.numerator = numerator * (denominator < 0 ? -1 : 1);
        this.denominator = Math.abs(denominator);
        normalization(this);
    }


    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public void setNumerator(int numerator){
        this.numerator = numerator;
    }

    public void setDenominator(int denominator){
        if (denominator == 0) {
            System.out.println("Denominator can't be zero. Choose another one.");
            return;
        }
        if (denominator < 0){
            this.numerator *= -1;
        }
    }

    private int gcd(int numerator, int denominator){
        while (numerator != 0 && denominator != 0) {
            if (numerator > denominator) {
                numerator %= denominator;
            } else {
                denominator %= numerator;
            }
        }
        return numerator + denominator;
    }

    private void normalization(Fraction obj){
        int n = gcd(Math.abs(obj.numerator), Math.abs(obj.denominator));
        obj.numerator /= n;
        obj.denominator /= n;
    }

    public boolean properFraction(){ //проверка правильности дроби
        return (Math.abs(numerator) < denominator ? true : false);
    }

    public int getIntegerPart(){ // выделение целой части
        return (numerator / denominator);
    }

    public Fraction fractionalPart(){ // выделение дробной части
        return new Fraction(numerator % denominator, denominator);
    }

    public double toDecimalFractions(){ // результат деления в виде десятичной дроби
        return (double) numerator / denominator;
    }

    public String toString(){ // вывод дроби на печать
        return new String(numerator + " / " + denominator);
    }

    public Fraction sub(Fraction obj1, Fraction obj2) { //Вычитание дробей
        Fraction obj3 = new Fraction(obj1.numerator * obj2.denominator - obj2.numerator * obj1.denominator, obj1.denominator * obj2.denominator);
        if (!properFraction())
            normalization(obj3);
        return obj3;
    }
    public Fraction sum(Fraction obj1, Fraction obj2){  //Сложение дробей
        Fraction obj3 = new Fraction(obj1.numerator * obj2.denominator + obj2.numerator * obj1.denominator, obj1.denominator * obj2.denominator);
        if (!properFraction())
            normalization(obj3);
        return obj3;
    }
    public Fraction comp(Fraction obj1, Fraction obj2) { //Произведение дробей
        Fraction obj3 = new Fraction(obj1.numerator *obj2.numerator, obj1.denominator * obj2.denominator);
        if (!properFraction())
            normalization(obj3);
        return obj3;
    }
    public Fraction div(Fraction obj1, Fraction obj2) {
        Fraction obj3 = new Fraction(obj1.numerator * obj2.denominator, obj1.denominator * obj2.numerator);
        if (!properFraction())
            normalization(obj3);
        return obj3;
    }
}
