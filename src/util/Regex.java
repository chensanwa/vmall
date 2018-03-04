package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    //验证字符串是否合乎指定正则
    public static boolean check(String value,String regex){
        boolean flag = false;
        try {
            Pattern pattern = Pattern.compile(value);
            Matcher matcher = pattern.matcher(value);
            flag = matcher.matches();
        }  catch (Exception e){
            flag = false;
        }
        return flag;
    }

    //验证是否为邮箱格式
    public static boolean checkEmail(String email) {
        String regex = "^([a-z0-9A-Z]+[-|_|\\.]?@(a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return check(email,regex);
    }

    //验证是否为手机号码格式或固话号码
    public static boolean checkPhoneNumber(String mobileNumber) {
        //手机
        String regexCellphone = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8}$";
        //固定电话
        String regexTelphone = "^(0\\\\d{2}-\\\\d{8}(-\\\\d{1,4})?)|(0\\\\d{3}-\\\\d{7,8}(-\\\\d{1,4})?)$";
        return (check(mobileNumber,regexCellphone) || check(mobileNumber,regexTelphone));
    }

    //非空验证
    public static boolean checkNotEmpty(String notEmpty){
        String regex = "^\\s*$";
        return check(notEmpty,regex);
    }

    //验证QQ
    public static boolean checkQQ(String qq){
        String regex = "^[1-9][0-9]{4,} $";
        return check(qq,regex);
    }
}
