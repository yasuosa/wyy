package cn.rpy.wyy.domain;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/3
 * @desc : 接收用户是否注册
 */
public class InfoRegister {

    /**
     * exist : -1
     * nickname : null
     * hasPassword : false
     * code : 200
     */

    private int exist;
    private Object nickname;
    private boolean hasPassword;
    private int code;

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public Object getNickname() {
        return nickname;
    }

    public void setNickname(Object nickname) {
        this.nickname = nickname;
    }

    public boolean isHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
