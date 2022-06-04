package test;

public class Item {
    public String entpName; //업체명
    public String itemName; //제품명
    public String itemImage;//약의 이미지 링크
    public String efcyQesitm; //약의 효능
    public String atpnWarnQesitm; //약 사용시 알아야할 내용
    public String useMethodQesitm; //약 사용 방법
    public String seQesitm; //약의 이상반응
    public String atpnQesitm; //약 사용시 주의 사항
    public String depositMethodQesitm; //약 보관 방법
    public String intrcQesitm; //약 복용시 주의해야할 음식 또는 약

    public Item() {
    }

    public void setEntpName(String entpName) {
        if (entpName.isEmpty()) {
            this.entpName = "내용 없음";
        } else {
            this.entpName = entpName;
        }
    }

    public void setItemName(String itemName) {
        if (itemName.isEmpty()) {
            this.itemName = "내용 없음";
        } else {
            this.itemName = itemName;
        }
    }

    public void setItemImage(String itemImage) {
        if (itemImage.isEmpty()) {
            this.itemImage = "./img/noimg.gif";
        } else {
            this.itemImage = itemImage;
        }
    }

    public void setEfcyQesitm(String efcyQesitm) {
        if (efcyQesitm.isEmpty()) {
            this.efcyQesitm = "내용 없음";
        } else {
            this.efcyQesitm = efcyQesitm;
        }
    }

    public void setAtpnWarnQesitm(String atpnWarnQesitm) {
        if (atpnWarnQesitm.isEmpty()) {
            this.atpnWarnQesitm = "내용 없음";
        } else {
            this.atpnWarnQesitm = atpnWarnQesitm;
        }
    }

    public void setUseMethodQesitm(String useMethodQesitm) {
        if (useMethodQesitm.isEmpty()) {
            this.useMethodQesitm = "내용 없음";
        } else {
            this.useMethodQesitm = useMethodQesitm;
        }
    }

    public void setSeQesitm(String seQesitm) {
        if (seQesitm.isEmpty()) {
            this.seQesitm = "내용 없음";
        } else {
            this.seQesitm = seQesitm;
        }
    }

    public void setAtpnQesitm(String atpnQesitm) {
        if (atpnQesitm.isEmpty()) {
            this.atpnQesitm = "내용 없음";
        } else {
            this.atpnQesitm = atpnQesitm;
        }
    }

    public void setDepositMethodQesitm(String depositMethodQesitm) {
        if (depositMethodQesitm.isEmpty()) {
            this.depositMethodQesitm = "내용 없음";
        } else {
            this.depositMethodQesitm = depositMethodQesitm;
        }
    }

    public void setIntrcQesitm(String intrcQesitm) {
        if (intrcQesitm.isEmpty()) {
            this.intrcQesitm = "내용 없음";
        } else {
            this.intrcQesitm = intrcQesitm;
        }
    }

    public String getEntpName() {
        return entpName;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public String getEfcyQesitm() {
        return efcyQesitm;
    }

    public String getAtpnWarnQesitm() {
        return atpnWarnQesitm;
    }

    public String getUseMethodQesitm() {
        return useMethodQesitm;
    }

    public String getSeQesitm() {
        return seQesitm;
    }

    public String getAtpnQesitm() {
        return atpnQesitm;
    }

    public String getDepositMethodQesitm() {
        return depositMethodQesitm;
    }

    public String getIntrcQesitm() {
        return intrcQesitm;
    }
}