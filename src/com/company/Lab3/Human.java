package com.company.Lab3;

public class Human {

    private int Height;
    private String name;

    Head a;
    Leg b1;
    Leg b2;
    Hand c1;
    Hand c2;
    public Human(int height, String name, Head c, Leg a1, Leg a2, Hand b1, Hand b2)
    {
        this.Height = height;
        this.name = name;
        this.a = c;
        this.b1 = a1;
        this.b2 = a2;
        this.c1 = b1;
        this.c2 = b2;
    }
    public static class Head {
        private String hair_style;
        private String shape;

        Head(String hair_style, String shape)
        {
            this.hair_style = hair_style;
            this.shape = shape;
        }
        public void setHair_style(String hair_style) {
            this.hair_style = hair_style;
        }

        public void setShape(String shape) {
            this.shape = shape;
        }

        public String getHair_style() {
            return hair_style;
        }

        public String getShape() {
            return shape;
        }

        @Override
        public String toString() {
            return "Head{" +
                    "hair_style='" + hair_style + '\'' +
                    ", shape='" + shape + '\'' +
                    '}';
        }
    }

    public static class Leg {
        private int length;

        Leg(int length) {
            this.length = length;
        }
        public void setLength(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        @Override
        public String toString() {
            return "Leg{" +
                    "length=" + length +
                    '}';
        }
    }

    public static class Hand {
        private String type_of_skin;

        Hand(String type_of_skin) {
            this.type_of_skin = type_of_skin;
        }
        public void setType_of_skin(String type_of_skin) {
            this.type_of_skin = type_of_skin;
        }

        public String getType_of_skin() {
            return type_of_skin;
        }

        @Override
        public String toString() {
            return "Hand{" +
                    "type_of_skin='" + type_of_skin + '\'' +
                    '}';
        }
    }

    public void setHeight(int height) {
        Height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "Height=" + Height +
                ", name='" + name + '\'' +
                ", a=" + a +
                ", b1=" + b1 +
                ", b2=" + b2 +
                ", c1=" + c1 +
                ", c2=" + c2 +
                '}';
    }
}