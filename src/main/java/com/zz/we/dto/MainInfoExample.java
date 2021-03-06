package com.zz.we.dto;

import java.util.ArrayList;
import java.util.List;

public class MainInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    public MainInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCoverIsNull() {
            addCriterion("cover is null");
            return (Criteria) this;
        }

        public Criteria andCoverIsNotNull() {
            addCriterion("cover is not null");
            return (Criteria) this;
        }

        public Criteria andCoverEqualTo(String value) {
            addCriterion("cover =", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotEqualTo(String value) {
            addCriterion("cover <>", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThan(String value) {
            addCriterion("cover >", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThanOrEqualTo(String value) {
            addCriterion("cover >=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThan(String value) {
            addCriterion("cover <", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThanOrEqualTo(String value) {
            addCriterion("cover <=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLike(String value) {
            addCriterion("cover like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotLike(String value) {
            addCriterion("cover not like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverIn(List<String> values) {
            addCriterion("cover in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotIn(List<String> values) {
            addCriterion("cover not in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverBetween(String value1, String value2) {
            addCriterion("cover between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotBetween(String value1, String value2) {
            addCriterion("cover not between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andHeIsNull() {
            addCriterion("he is null");
            return (Criteria) this;
        }

        public Criteria andHeIsNotNull() {
            addCriterion("he is not null");
            return (Criteria) this;
        }

        public Criteria andHeEqualTo(String value) {
            addCriterion("he =", value, "he");
            return (Criteria) this;
        }

        public Criteria andHeNotEqualTo(String value) {
            addCriterion("he <>", value, "he");
            return (Criteria) this;
        }

        public Criteria andHeGreaterThan(String value) {
            addCriterion("he >", value, "he");
            return (Criteria) this;
        }

        public Criteria andHeGreaterThanOrEqualTo(String value) {
            addCriterion("he >=", value, "he");
            return (Criteria) this;
        }

        public Criteria andHeLessThan(String value) {
            addCriterion("he <", value, "he");
            return (Criteria) this;
        }

        public Criteria andHeLessThanOrEqualTo(String value) {
            addCriterion("he <=", value, "he");
            return (Criteria) this;
        }

        public Criteria andHeLike(String value) {
            addCriterion("he like", value, "he");
            return (Criteria) this;
        }

        public Criteria andHeNotLike(String value) {
            addCriterion("he not like", value, "he");
            return (Criteria) this;
        }

        public Criteria andHeIn(List<String> values) {
            addCriterion("he in", values, "he");
            return (Criteria) this;
        }

        public Criteria andHeNotIn(List<String> values) {
            addCriterion("he not in", values, "he");
            return (Criteria) this;
        }

        public Criteria andHeBetween(String value1, String value2) {
            addCriterion("he between", value1, value2, "he");
            return (Criteria) this;
        }

        public Criteria andHeNotBetween(String value1, String value2) {
            addCriterion("he not between", value1, value2, "he");
            return (Criteria) this;
        }

        public Criteria andSheIsNull() {
            addCriterion("she is null");
            return (Criteria) this;
        }

        public Criteria andSheIsNotNull() {
            addCriterion("she is not null");
            return (Criteria) this;
        }

        public Criteria andSheEqualTo(String value) {
            addCriterion("she =", value, "she");
            return (Criteria) this;
        }

        public Criteria andSheNotEqualTo(String value) {
            addCriterion("she <>", value, "she");
            return (Criteria) this;
        }

        public Criteria andSheGreaterThan(String value) {
            addCriterion("she >", value, "she");
            return (Criteria) this;
        }

        public Criteria andSheGreaterThanOrEqualTo(String value) {
            addCriterion("she >=", value, "she");
            return (Criteria) this;
        }

        public Criteria andSheLessThan(String value) {
            addCriterion("she <", value, "she");
            return (Criteria) this;
        }

        public Criteria andSheLessThanOrEqualTo(String value) {
            addCriterion("she <=", value, "she");
            return (Criteria) this;
        }

        public Criteria andSheLike(String value) {
            addCriterion("she like", value, "she");
            return (Criteria) this;
        }

        public Criteria andSheNotLike(String value) {
            addCriterion("she not like", value, "she");
            return (Criteria) this;
        }

        public Criteria andSheIn(List<String> values) {
            addCriterion("she in", values, "she");
            return (Criteria) this;
        }

        public Criteria andSheNotIn(List<String> values) {
            addCriterion("she not in", values, "she");
            return (Criteria) this;
        }

        public Criteria andSheBetween(String value1, String value2) {
            addCriterion("she between", value1, value2, "she");
            return (Criteria) this;
        }

        public Criteria andSheNotBetween(String value1, String value2) {
            addCriterion("she not between", value1, value2, "she");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andLunarIsNull() {
            addCriterion("lunar is null");
            return (Criteria) this;
        }

        public Criteria andLunarIsNotNull() {
            addCriterion("lunar is not null");
            return (Criteria) this;
        }

        public Criteria andLunarEqualTo(String value) {
            addCriterion("lunar =", value, "lunar");
            return (Criteria) this;
        }

        public Criteria andLunarNotEqualTo(String value) {
            addCriterion("lunar <>", value, "lunar");
            return (Criteria) this;
        }

        public Criteria andLunarGreaterThan(String value) {
            addCriterion("lunar >", value, "lunar");
            return (Criteria) this;
        }

        public Criteria andLunarGreaterThanOrEqualTo(String value) {
            addCriterion("lunar >=", value, "lunar");
            return (Criteria) this;
        }

        public Criteria andLunarLessThan(String value) {
            addCriterion("lunar <", value, "lunar");
            return (Criteria) this;
        }

        public Criteria andLunarLessThanOrEqualTo(String value) {
            addCriterion("lunar <=", value, "lunar");
            return (Criteria) this;
        }

        public Criteria andLunarLike(String value) {
            addCriterion("lunar like", value, "lunar");
            return (Criteria) this;
        }

        public Criteria andLunarNotLike(String value) {
            addCriterion("lunar not like", value, "lunar");
            return (Criteria) this;
        }

        public Criteria andLunarIn(List<String> values) {
            addCriterion("lunar in", values, "lunar");
            return (Criteria) this;
        }

        public Criteria andLunarNotIn(List<String> values) {
            addCriterion("lunar not in", values, "lunar");
            return (Criteria) this;
        }

        public Criteria andLunarBetween(String value1, String value2) {
            addCriterion("lunar between", value1, value2, "lunar");
            return (Criteria) this;
        }

        public Criteria andLunarNotBetween(String value1, String value2) {
            addCriterion("lunar not between", value1, value2, "lunar");
            return (Criteria) this;
        }

        public Criteria andHotelIsNull() {
            addCriterion("hotel is null");
            return (Criteria) this;
        }

        public Criteria andHotelIsNotNull() {
            addCriterion("hotel is not null");
            return (Criteria) this;
        }

        public Criteria andHotelEqualTo(String value) {
            addCriterion("hotel =", value, "hotel");
            return (Criteria) this;
        }

        public Criteria andHotelNotEqualTo(String value) {
            addCriterion("hotel <>", value, "hotel");
            return (Criteria) this;
        }

        public Criteria andHotelGreaterThan(String value) {
            addCriterion("hotel >", value, "hotel");
            return (Criteria) this;
        }

        public Criteria andHotelGreaterThanOrEqualTo(String value) {
            addCriterion("hotel >=", value, "hotel");
            return (Criteria) this;
        }

        public Criteria andHotelLessThan(String value) {
            addCriterion("hotel <", value, "hotel");
            return (Criteria) this;
        }

        public Criteria andHotelLessThanOrEqualTo(String value) {
            addCriterion("hotel <=", value, "hotel");
            return (Criteria) this;
        }

        public Criteria andHotelLike(String value) {
            addCriterion("hotel like", value, "hotel");
            return (Criteria) this;
        }

        public Criteria andHotelNotLike(String value) {
            addCriterion("hotel not like", value, "hotel");
            return (Criteria) this;
        }

        public Criteria andHotelIn(List<String> values) {
            addCriterion("hotel in", values, "hotel");
            return (Criteria) this;
        }

        public Criteria andHotelNotIn(List<String> values) {
            addCriterion("hotel not in", values, "hotel");
            return (Criteria) this;
        }

        public Criteria andHotelBetween(String value1, String value2) {
            addCriterion("hotel between", value1, value2, "hotel");
            return (Criteria) this;
        }

        public Criteria andHotelNotBetween(String value1, String value2) {
            addCriterion("hotel not between", value1, value2, "hotel");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appid like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appid not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appid not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(String value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(String value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(String value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(String value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(String value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(String value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLike(String value) {
            addCriterion("lng like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotLike(String value) {
            addCriterion("lng not like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<String> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<String> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(String value1, String value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(String value1, String value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andMusicUrlIsNull() {
            addCriterion("music_url is null");
            return (Criteria) this;
        }

        public Criteria andMusicUrlIsNotNull() {
            addCriterion("music_url is not null");
            return (Criteria) this;
        }

        public Criteria andMusicUrlEqualTo(String value) {
            addCriterion("music_url =", value, "musicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicUrlNotEqualTo(String value) {
            addCriterion("music_url <>", value, "musicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicUrlGreaterThan(String value) {
            addCriterion("music_url >", value, "musicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("music_url >=", value, "musicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicUrlLessThan(String value) {
            addCriterion("music_url <", value, "musicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicUrlLessThanOrEqualTo(String value) {
            addCriterion("music_url <=", value, "musicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicUrlLike(String value) {
            addCriterion("music_url like", value, "musicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicUrlNotLike(String value) {
            addCriterion("music_url not like", value, "musicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicUrlIn(List<String> values) {
            addCriterion("music_url in", values, "musicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicUrlNotIn(List<String> values) {
            addCriterion("music_url not in", values, "musicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicUrlBetween(String value1, String value2) {
            addCriterion("music_url between", value1, value2, "musicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicUrlNotBetween(String value1, String value2) {
            addCriterion("music_url not between", value1, value2, "musicUrl");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mainInfo
     *
     * @mbg.generated do_not_delete_during_merge Mon Jun 24 13:51:08 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mainInfo
     *
     * @mbg.generated Mon Jun 24 13:51:08 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}