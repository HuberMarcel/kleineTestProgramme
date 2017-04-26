package de.marcelhuber.pruefungsvorbereitung.ocp;
// Ein bisschen Eigenkreation für einen Builder

/**
 *
 * @author Marcel Huber
 */
public class Human {

    private String name;                   // Pflichtattribut
    private int age;                       // Pflichtattribut
    private String city;
    private String telephonnumber;
    private boolean isMarried;

    private Human(Builder b) {
        this.name = b.name;
        this.age = b.age;
        this.city = b.city;
        this.telephonnumber = b.telephonnumber;
        this.isMarried = b.isMarried;
    }

    static public class Builder {            // das static ist hier WICHTIG

        private String name;                 // Pflichtattribut
        private int age;                     // Pflichtattribut

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
        private String city;
        private String telephonnumber;
        private boolean isMarried;

        static public class IsNecessary {

            private Builder builderNecessaryName;
            private Builder builderNecessaryAge;

            public IsNecessary() {
            }

            public IsNecessary name(String name) {
                builderNecessaryName = new Builder();
                builderNecessaryName.name = name;
                return this;
            }

            public IsNecessary age(int age) {
                builderNecessaryAge = new Builder();
                builderNecessaryAge.age = age;
                return this;
            }

            public IsNecessary(String name, int age) {
                builderNecessaryName = new Builder();
                builderNecessaryAge = new Builder();
                builderNecessaryName.name = name;
                builderNecessaryAge.age = age;
            }

            public Builder buildIsNecessary() {
                return new Builder(builderNecessaryName.name, builderNecessaryAge.age);
            }
        }

        private Builder() {
        }

        public Builder(String name, int age) {    // Z1
            this.name = name;
            this.age = age;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder telephonnumber(String telephonnumber) {
            this.telephonnumber = telephonnumber;
            return this;
        }

        public Builder isMarried(boolean isMarried) {
            this.isMarried = isMarried;
            return this;
        }

        public Human build() {
            return new Human(this);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephonnumber() {
        return telephonnumber;
    }

    public void setTelephonnumber(String telephonnumber) {
        this.telephonnumber = telephonnumber;
    }

    public boolean isIsMarried() {
        return isMarried;
    }

    public void setIsMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public String toString() {
        return "Name:           " + name
                + "\nAge:            " + age
                + "\nCity:           " + city
                + "\nTelephonnumber: " + telephonnumber
                + "\nis married:     " + isMarried;
    }

}

class TestHuman {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new TestHuman().go();
    }

    private void go() {
        System.out.println("");
//        Human marcel = new Human.Builder()                   
//                .nameAge("Marcel Huber", 36)
//                .city("Trier")
//                .isMarried(false)
//                .telephonnumber("06 51 xx xx xx xx")
//                .build();
//        System.out.println(marcel);

//        Human marcel = new Human.Builder.IsNecessary()    // so knallt es zur Laufzeit
//                .name("Marcel")
//                .buildIsNecessary()
//                .build();
//        Human marcel = new Human.Builder.IsNecessary()
        Human marcel = new Human.Builder.IsNecessary("name", 0)
                .age(36)
                .name("Marcel")
                .buildIsNecessary()
                .city("Trier")
                .isMarried(false)
                .telephonnumber("xx xx xx xx xx xx")
                .build();
        System.out.println(marcel);
        System.out.println("");
        
        Human sascha = new Human.Builder("Sascha", 38)
                .city("Trier")
                .isMarried(false)
                .telephonnumber("xx xx xx xx xx xx")
                .build();
        System.out.println(sascha);
        System.out.println("");
        
        Human pascal = new Human.Builder.IsNecessary()
                .age(24)
                .name("Pascal")
                .buildIsNecessary()
                .city("Trier")
                .build();
        System.out.println(pascal);

    }
}
