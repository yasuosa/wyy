package cn.rpy.wyy.domain;

import java.util.List;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/3
 * @desc : 登陆成功后
 */
public class LoginInfo {

    /**
     * loginType : 1
     * code : 200
     * account : {"id":340614018,"userName":"1_18255990660","type":1,"status":0,"whitelistAuthority":0,"createTime":1475330255639,"salt":"[B@71462076","tokenVersion":1,"ban":0,"baoyueVersion":1,"donateVersion":0,"vipType":11,"viptypeVersion":1573563276224,"anonimousUser":false}
     * profile : {"mutual":false,"remarkName":null,"expertTags":null,"authStatus":0,"city":341000,"userType":0,"backgroundImgId":109951163748475700,"province":340000,"defaultAvatar":false,"avatarUrl":"https://p3.music.126.net/RgHpQ4VhZyiDod9Yp66m5A==/109951163615933733.jpg","experts":{},"djStatus":0,"userId":340614018,"vipType":11,"gender":1,"accountStatus":0,"avatarImgId":109951163615933730,"nickname":"别随缘了","birthday":940089600000,"avatarImgIdStr":"109951163615933733","backgroundImgIdStr":"109951163748475691","detailDescription":"","followed":false,"backgroundUrl":"https://p4.music.126.net/DOLr0_5GYr6XqOgYPlFnBw==/109951163748475691.jpg","description":"","signature":"","authority":0,"avatarImgId_str":"109951163615933733","followeds":6,"follows":13,"eventCount":2,"playlistCount":4,"playlistBeSubscribedCount":0}
     * bindings : [{"expiresIn":2147483647,"bindingTime":1475330274224,"tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"18255990660\",\"hasPassword\":true}","userId":340614018,"refreshTime":1475330274,"url":"","expired":false,"id":2904690753,"type":1},{"expiresIn":7776000,"bindingTime":1475330255800,"tokenJsonStr":"{\"access_token\":\"9E04ACABAEB82F8D6CB15DC3EF3FA413\",\"openid\":\"508946782A139EBBC97E60C9788199D5\",\"query_authority_cost\":63,\"nickname\":\"Unable\",\"partnerType\":\"0\",\"expires_in\":7776000,\"login_cost\":211,\"authority_cost\":819}","userId":340614018,"refreshTime":1568208892,"url":"","expired":false,"id":2904690754,"type":5}]
     */

    private int loginType;
    private int code;
    private AccountBean account;
    private ProfileBean profile;
    private List<BindingsBean> bindings;
    private String msg;
    private String message;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }

    public static class AccountBean {
        /**
         * id : 340614018
         * userName : 1_18255990660
         * type : 1
         * status : 0
         * whitelistAuthority : 0
         * createTime : 1475330255639
         * salt : [B@71462076
         * tokenVersion : 1
         * ban : 0
         * baoyueVersion : 1
         * donateVersion : 0
         * vipType : 11
         * viptypeVersion : 1573563276224
         * anonimousUser : false
         */

        private int id;
        private String userName;
        private int type;
        private int status;
        private int whitelistAuthority;
        private long createTime;
        private String salt;
        private int tokenVersion;
        private int ban;
        private int baoyueVersion;
        private int donateVersion;
        private int vipType;
        private long viptypeVersion;
        private boolean anonimousUser;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getWhitelistAuthority() {
            return whitelistAuthority;
        }

        public void setWhitelistAuthority(int whitelistAuthority) {
            this.whitelistAuthority = whitelistAuthority;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getTokenVersion() {
            return tokenVersion;
        }

        public void setTokenVersion(int tokenVersion) {
            this.tokenVersion = tokenVersion;
        }

        public int getBan() {
            return ban;
        }

        public void setBan(int ban) {
            this.ban = ban;
        }

        public int getBaoyueVersion() {
            return baoyueVersion;
        }

        public void setBaoyueVersion(int baoyueVersion) {
            this.baoyueVersion = baoyueVersion;
        }

        public int getDonateVersion() {
            return donateVersion;
        }

        public void setDonateVersion(int donateVersion) {
            this.donateVersion = donateVersion;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public long getViptypeVersion() {
            return viptypeVersion;
        }

        public void setViptypeVersion(long viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
        }

        public boolean isAnonimousUser() {
            return anonimousUser;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }
    }

    public static class ProfileBean {
        /**
         * mutual : false
         * remarkName : null
         * expertTags : null
         * authStatus : 0
         * city : 341000
         * userType : 0
         * backgroundImgId : 109951163748475700
         * province : 340000
         * defaultAvatar : false
         * avatarUrl : https://p3.music.126.net/RgHpQ4VhZyiDod9Yp66m5A==/109951163615933733.jpg
         * experts : {}
         * djStatus : 0
         * userId : 340614018
         * vipType : 11
         * gender : 1
         * accountStatus : 0
         * avatarImgId : 109951163615933730
         * nickname : 别随缘了
         * birthday : 940089600000
         * avatarImgIdStr : 109951163615933733
         * backgroundImgIdStr : 109951163748475691
         * detailDescription :
         * followed : false
         * backgroundUrl : https://p4.music.126.net/DOLr0_5GYr6XqOgYPlFnBw==/109951163748475691.jpg
         * description :
         * signature :
         * authority : 0
         * avatarImgId_str : 109951163615933733
         * followeds : 6
         * follows : 13
         * eventCount : 2
         * playlistCount : 4
         * playlistBeSubscribedCount : 0
         */

        private boolean mutual;
        private Object remarkName;
        private Object expertTags;
        private int authStatus;
        private int city;
        private int userType;
        private long backgroundImgId;
        private int province;
        private boolean defaultAvatar;
        private String avatarUrl;
        private ExpertsBean experts;
        private int djStatus;
        private int userId;
        private int vipType;
        private int gender;
        private int accountStatus;
        private long avatarImgId;
        private String nickname;
        private long birthday;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private String detailDescription;
        private boolean followed;
        private String backgroundUrl;
        private String description;
        private String signature;
        private int authority;
        private String avatarImgId_str;
        private int followeds;
        private int follows;
        private int eventCount;
        private int playlistCount;
        private int playlistBeSubscribedCount;

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public ExpertsBean getExperts() {
            return experts;
        }

        public void setExperts(ExpertsBean experts) {
            this.experts = experts;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public String getAvatarImgId_str() {
            return avatarImgId_str;
        }

        public void setAvatarImgId_str(String avatarImgId_str) {
            this.avatarImgId_str = avatarImgId_str;
        }

        public int getFolloweds() {
            return followeds;
        }

        public void setFolloweds(int followeds) {
            this.followeds = followeds;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
        }

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public int getPlaylistBeSubscribedCount() {
            return playlistBeSubscribedCount;
        }

        public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
            this.playlistBeSubscribedCount = playlistBeSubscribedCount;
        }

        public static class ExpertsBean {
        }
    }

    public static class BindingsBean {
        /**
         * expiresIn : 2147483647
         * bindingTime : 1475330274224
         * tokenJsonStr : {"countrycode":"","cellphone":"18255990660","hasPassword":true}
         * userId : 340614018
         * refreshTime : 1475330274
         * url :
         * expired : false
         * id : 2904690753
         * type : 1
         */

        private int expiresIn;
        private long bindingTime;
        private String tokenJsonStr;
        private int userId;
        private int refreshTime;
        private String url;
        private boolean expired;
        private long id;
        private int type;

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public long getBindingTime() {
            return bindingTime;
        }

        public void setBindingTime(long bindingTime) {
            this.bindingTime = bindingTime;
        }

        public String getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(String tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(int refreshTime) {
            this.refreshTime = refreshTime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
