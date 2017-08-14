package containers.multisort;

public class StatReport {
    public Integer id = (int) (Math.random() * 100);
    public String realName = "name" + id;
    public String klassName = "klassName" + (int) (Math.random() * 10);
    public Integer examScore = id;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName the realName to set
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * @return the klassName
     */
    public String getKlassName() {
        return klassName;
    }

    /**
     * @param klassName the klassName to set
     */
    public void setKlassName(String klassName) {
        this.klassName = klassName;
    }

    /**
     * @return the examScore
     */
    public Integer getExamScore() {
        return examScore;
    }

    /**
     * @param examScore the examScore to set
     */
    public void setExamScore(Integer examScore) {
        this.examScore = examScore;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "StatReport [realName=" + realName + ", klassName=" + klassName + ", examScore=" + examScore + "] \n";
    }

}
