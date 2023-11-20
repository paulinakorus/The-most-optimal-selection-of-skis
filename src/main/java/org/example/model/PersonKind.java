package org.example.model;

public enum PersonKind {                // enum -
    C(50), J(20), A(0);

    private final Integer discountValue;

    PersonKind(Integer discountValue){
        this.discountValue = discountValue;
    }

    public static PersonKind readPersonKind(String kind){
        switch (kind){
            case "C":
                return PersonKind.C;
            case "A":
                return PersonKind.A;
            case "J":
                return PersonKind.J;
            default:
                return null;
        }
    }

    public Integer getDiscountValue(){
        return discountValue;
    }
}
