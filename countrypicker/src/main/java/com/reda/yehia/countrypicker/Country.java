package com.reda.yehia.countrypicker;

/**
 * Created by yehia on 27/05/19.
 */


import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Country {

    private static Country[] COUNTRIES;
    private String code;
    private String name;
    private String dialCode;
    private int flag = -1;
    private int length_min = 0;
    private int length_max = 1;
    private static List<Country> allCountriesList;

    public Country(String code, String name, String dialCode, int flag, int length_min, int length_max) {
        this.code = code;
        this.name = name;
        this.dialCode = dialCode;
        this.flag = flag;
        this.length_min = length_min;
        this.length_max = length_max;
    }

    public Country() {
    }

    public String getDialCode() {
        return this.dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
        if (TextUtils.isEmpty(this.name)) {
            this.name = (new Locale("", code)).getDisplayName();
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength_min() {
        return length_min;
    }

    public void setLength_min(int length_min) {
        this.length_min = length_min;
    }

    public int getLength_max() {
        return length_max;
    }

    public void setLength_max(int length_max) {
        this.length_max = length_max;
    }

    public String getName() {
        return this.name;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void loadFlagByCode(Context context) {
        if (this.flag == -1) {
            try {
                this.flag = context.getResources().getIdentifier("flag_" + this.code.toLowerCase(Locale.ENGLISH), "drawable", context.getPackageName());
            } catch (Exception var3) {
                var3.printStackTrace();
                this.flag = -1;
            }

        }
    }

    public static List<Country> getAllCountries() {
        if (allCountriesList == null) {
            allCountriesList = Arrays.asList(COUNTRIES);
        }

        return allCountriesList;
    }

    public static Country getCountryByISO(String countryIsoCode) {
        countryIsoCode = countryIsoCode.toUpperCase();
        Country c = new Country();
        c.setCode(countryIsoCode);
        int i = Arrays.binarySearch(COUNTRIES, c,
                new ISOCodeComparator());
        return i < 0 ? null : COUNTRIES[i];
    }

    public static Country getCountryByName(String countryName) {
        Country[] var1 = COUNTRIES;
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            Country c = var1[var3];
            if (countryName.equals(c.getName())) {
                return c;
            }
        }

        return null;
    }

    public static Country getCountryByLocale(Locale locale) {
        String countryIsoCode = locale.getISO3Country().substring(0, 2).toLowerCase();
        return getCountryByISO(countryIsoCode);
    }

    public static Country getCountryFromSIM(Context context) {
        @SuppressLint("WrongConstant") TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager.getSimState() != 1 ? getCountryByISO(telephonyManager.getSimCountryIso()) : null;
    }

    static {
        COUNTRIES = new Country[]{
                new Country("AD", "Andorra", "+376", R.drawable.flag_ad, 0, 1)
                , new Country("AE", "United Arab Emirates", "+971", R.drawable.flag_ae, 0, 1)
                , new Country("AF", "Afghanistan", "+93", R.drawable.flag_af, 0, 1)
                , new Country("AG", "Antigua and Barbuda", "+1", R.drawable.flag_ag, 0, 1)
                , new Country("AI", "Anguilla", "+1", R.drawable.flag_ai, 0, 1)
                , new Country("AL", "Albania", "+355", R.drawable.flag_al, 0, 1)
                , new Country("AM", "Armenia", "+374", R.drawable.flag_am, 0, 1)
                , new Country("AO", "Angola", "+244", R.drawable.flag_ao, 0, 1)
                , new Country("AQ", "Antarctica", "+672", R.drawable.flag_aq, 0, 1)
                , new Country("AR", "Argentina", "+54", R.drawable.flag_ar, 0, 1)
                , new Country("AS", "AmericanSamoa", "+1", R.drawable.flag_as, 0, 1)
                , new Country("AT", "Austria", "+43", R.drawable.flag_at, 0, 1)
                , new Country("AU", "Australia", "+61", R.drawable.flag_au, 0, 1)
                , new Country("AW", "Aruba", "+297", R.drawable.flag_aw, 0, 1)
                , new Country("AX", "Åland Islands", "+358", R.drawable.flag_ax, 0, 1)
                , new Country("AZ", "Azerbaijan", "+994", R.drawable.flag_az, 0, 1)
                , new Country("BA", "Bosnia and Herzegovina", "+387", R.drawable.flag_ba, 0, 1)
                , new Country("BB", "Barbados", "+1", R.drawable.flag_bb, 0, 1)
                , new Country("BD", "Bangladesh", "+880", R.drawable.flag_bd, 0, 1)
                , new Country("BE", "Belgium", "+32", R.drawable.flag_be, 0, 1)
                , new Country("BF", "Burkina Faso", "+226", R.drawable.flag_bf, 0, 1)
                , new Country("BG", "Bulgaria", "+359", R.drawable.flag_bg, 0, 1)
                , new Country("BH", "Bahrain", "+973", R.drawable.flag_bh, 0, 1)
                , new Country("BI", "Burundi", "+257", R.drawable.flag_bi, 0, 1)
                , new Country("BJ", "Benin", "+229", R.drawable.flag_bj, 0, 1)
                , new Country("BL", "Saint Barthélemy", "+590", R.drawable.flag_bl, 0, 1)
                , new Country("BM", "Bermuda", "+1", R.drawable.flag_bm, 0, 1)
                , new Country("BN", "Brunei Darussalam", "+673", R.drawable.flag_bn, 0, 1)
                , new Country("BO", "Bolivia, Plurinational State of", "+591", R.drawable.flag_bo, 0, 1)
                , new Country("BQ", "Bonaire", "+599", R.drawable.flag_bq, 0, 1)
                , new Country("BR", "Brazil", "+55", R.drawable.flag_br, 0, 1)
                , new Country("BS", "Bahamas", "+1", R.drawable.flag_bs, 0, 1)
                , new Country("BT", "Bhutan", "+975", R.drawable.flag_bt, 0, 1)
                , new Country("BV", "Bouvet Island", "+47", R.drawable.flag_bv, 0, 1)
                , new Country("BW", "Botswana", "+267", R.drawable.flag_bw, 0, 1)
                , new Country("BY", "Belarus", "+375", R.drawable.flag_by, 0, 1)
                , new Country("BZ", "Belize", "+501", R.drawable.flag_bz, 0, 1)
                , new Country("CA", "Canada", "+1", R.drawable.flag_ca, 0, 1)
                , new Country("CC", "Cocos (Keeling) Islands", "+61", R.drawable.flag_cc, 0, 1)
                , new Country("CD", "Congo, The Democratic Republic of the", "+243", R.drawable.flag_cd, 0, 1)
                , new Country("CF", "Central African Republic", "+236", R.drawable.flag_cf, 0, 1)
                , new Country("CG", "Congo", "+242", R.drawable.flag_cg, 0, 1)
                , new Country("CH", "Switzerland", "+41", R.drawable.flag_ch, 0, 1)
                , new Country("CI", "Ivory Coast", "+225", R.drawable.flag_ci, 0, 1)
                , new Country("CK", "Cook Islands", "+682", R.drawable.flag_ck, 0, 1)
                , new Country("CL", "Chile", "+56", R.drawable.flag_cl, 0, 1)
                , new Country("CM", "Cameroon", "+237", R.drawable.flag_cm, 0, 1)
                , new Country("CN", "China", "+86", R.drawable.flag_cn, 0, 1)
                , new Country("CO", "Colombia", "+57", R.drawable.flag_co, 0, 1)
                , new Country("CR", "Costa Rica", "+506", R.drawable.flag_cr, 0, 1)
                , new Country("CU", "Cuba", "+53", R.drawable.flag_cu, 0, 1)
                , new Country("CV", "Cape Verde", "+238", R.drawable.flag_cv, 0, 1)
                , new Country("CW", "Curacao", "+599", R.drawable.flag_cw, 0, 1)
                , new Country("CX", "Christmas Island", "+61", R.drawable.flag_cx, 0, 1)
                , new Country("CY", "Cyprus", "+357", R.drawable.flag_cy, 0, 1)
                , new Country("CZ", "Czech Republic", "+420", R.drawable.flag_cz, 0, 1)
                , new Country("DE", "Germany", "+49", R.drawable.flag_de, 0, 1)
                , new Country("DJ", "Djibouti", "+253", R.drawable.flag_dj, 0, 1)
                , new Country("DK", "Denmark", "+45", R.drawable.flag_dk, 0, 1)
                , new Country("DM", "Dominica", "+1", R.drawable.flag_dm, 0, 1)
                , new Country("DO", "Dominican Republic", "+1", R.drawable.flag_do, 0, 1)
                , new Country("DZ", "Algeria", "+213", R.drawable.flag_dz, 0, 1)
                , new Country("EC", "Ecuador", "+593", R.drawable.flag_ec, 0, 1)
                , new Country("EE", "Estonia", "+372", R.drawable.flag_ee, 0, 1)
                , new Country("EG", "Egypt", "+20", R.drawable.flag_eg, 11, 12)
                , new Country("EH", "Western Sahara", "+212", R.drawable.flag_eh, 0, 1)
                , new Country("ER", "Eritrea", "+291", R.drawable.flag_er, 0, 1)
                , new Country("ES", "Spain", "+34", R.drawable.flag_es, 0, 1)
                , new Country("ET", "Ethiopia", "+251", R.drawable.flag_et, 0, 1)
                , new Country("FI", "Finland", "+358", R.drawable.flag_fi, 0, 1)
                , new Country("FJ", "Fiji", "+679", R.drawable.flag_fj, 0, 1)
                , new Country("FK", "Falkland Islands (Malvinas)", "+500", R.drawable.flag_fk, 0, 1)
                , new Country("FM", "Micronesia, Federated States of", "+691", R.drawable.flag_fm, 0, 1)
                , new Country("FO", "Faroe Islands", "+298", R.drawable.flag_fo, 0, 1)
                , new Country("FR", "France", "+33", R.drawable.flag_fr, 0, 1)
                , new Country("GA", "Gabon", "+241", R.drawable.flag_ga, 0, 1)
                , new Country("GB", "United Kingdom", "+44", R.drawable.flag_gb, 0, 1)
                , new Country("GD", "Grenada", "+1", R.drawable.flag_gd, 0, 1)
                , new Country("GE", "Georgia", "+995", R.drawable.flag_ge, 0, 1)
                , new Country("GF", "French Guiana", "+594", R.drawable.flag_gf, 0, 1)
                , new Country("GG", "Guernsey", "+44", R.drawable.flag_gg, 0, 1)
                , new Country("GH", "Ghana", "+233", R.drawable.flag_gh, 0, 1)
                , new Country("GI", "Gibraltar", "+350", R.drawable.flag_gi, 0, 1)
                , new Country("GL", "Greenland", "+299", R.drawable.flag_gl, 0, 1)
                , new Country("GM", "Gambia", "+220", R.drawable.flag_gm, 0, 1)
                , new Country("GN", "Guinea", "+224", R.drawable.flag_gn, 0, 1)
                , new Country("GP", "Guadeloupe", "+590", R.drawable.flag_gp, 0, 1)
                , new Country("GQ", "Equatorial Guinea", "+240", R.drawable.flag_gq, 0, 1)
                , new Country("GR", "Greece", "+30", R.drawable.flag_gr, 0, 1)
                , new Country("GS", "South Georgia and the South Sandwich Islands", "+500", R.drawable.flag_gs, 0, 1)
                , new Country("GT", "Guatemala", "+502", R.drawable.flag_gt, 0, 1)
                , new Country("GU", "Guam", "+1", R.drawable.flag_gu, 0, 1)
                , new Country("GW", "Guinea-Bissau", "+245", R.drawable.flag_gw, 0, 1)
                , new Country("GY", "Guyana", "+595", R.drawable.flag_gy, 0, 1)
                , new Country("HK", "Hong Kong", "+852", R.drawable.flag_hk, 0, 1)
                , new Country("HM", "Heard Island and McDonald Islands", "", R.drawable.flag_hm, 0, 1)
                , new Country("HN", "Honduras", "+504", R.drawable.flag_hn, 0, 1)
                , new Country("HR", "Croatia", "+385", R.drawable.flag_hr, 0, 1)
                , new Country("HT", "Haiti", "+509", R.drawable.flag_ht, 0, 1)
                , new Country("HU", "Hungary", "+36", R.drawable.flag_hu, 0, 1)
                , new Country("ID", "Indonesia", "+62", R.drawable.flag_id, 0, 1)
                , new Country("IE", "Ireland", "+353", R.drawable.flag_ie, 0, 1)
                , new Country("IL", "Israel", "+972", R.drawable.flag_il, 0, 1)
                , new Country("IM", "Isle of Man", "+44", R.drawable.flag_im, 0, 1)
                , new Country("IN", "India", "+91", R.drawable.flag_in, 0, 1)
                , new Country("IO", "British Indian Ocean Territory", "+246", R.drawable.flag_io, 0, 1)
                , new Country("IQ", "Iraq", "+964", R.drawable.flag_iq, 0, 1)
                , new Country("IR", "Iran, Islamic Republic of", "+98", R.drawable.flag_ir, 0, 1)
                , new Country("IS", "Iceland", "+354", R.drawable.flag_is, 0, 1)
                , new Country("IT", "Italy", "+39", R.drawable.flag_it, 0, 1)
                , new Country("JE", "Jersey", "+44", R.drawable.flag_je, 0, 1)
                , new Country("JM", "Jamaica", "+1", R.drawable.flag_jm, 0, 1)
                , new Country("JO", "Jordan", "+962", R.drawable.flag_jo, 0, 1)
                , new Country("JP", "Japan", "+81", R.drawable.flag_jp, 0, 1)
                , new Country("KE", "Kenya", "+254", R.drawable.flag_ke, 0, 1)
                , new Country("KG", "Kyrgyzstan", "+996", R.drawable.flag_kg, 0, 1)
                , new Country("KH", "Cambodia", "+855", R.drawable.flag_kh, 0, 1)
                , new Country("KI", "Kiribati", "+686", R.drawable.flag_ki, 0, 1)
                , new Country("KM", "Comoros", "+269", R.drawable.flag_km, 0, 1)
                , new Country("KN", "Saint Kitts and Nevis", "+1", R.drawable.flag_kn, 0, 1)
                , new Country("KP", "North Korea", "+850", R.drawable.flag_kp, 0, 1)
                , new Country("KR", "South Korea", "+82", R.drawable.flag_kr, 0, 1)
                , new Country("KW", "Kuwait", "+965", R.drawable.flag_kw, 0, 1)
                , new Country("KY", "Cayman Islands", "+345", R.drawable.flag_ky, 0, 1)
                , new Country("KZ", "Kazakhstan", "+7", R.drawable.flag_kz, 0, 1)
                , new Country("LA", "Lao People\'s Democratic Republic", "+856", R.drawable.flag_la, 0, 1)
                , new Country("LB", "Lebanon", "+961", R.drawable.flag_lb, 0, 1)
                , new Country("LC", "Saint Lucia", "+1", R.drawable.flag_lc, 0, 1)
                , new Country("LI", "Liechtenstein", "+423", R.drawable.flag_li, 0, 1)
                , new Country("LK", "Sri Lanka", "+94", R.drawable.flag_lk, 0, 1)
                , new Country("LR", "Liberia", "+231", R.drawable.flag_lr, 0, 1)
                , new Country("LS", "Lesotho", "+266", R.drawable.flag_ls, 0, 1)
                , new Country("LT", "Lithuania", "+370", R.drawable.flag_lt, 0, 1)
                , new Country("LU", "Luxembourg", "+352", R.drawable.flag_lu, 0, 1)
                , new Country("LV", "Latvia", "+371", R.drawable.flag_lv, 0, 1)
                , new Country("LY", "Libyan Arab Jamahiriya", "+218", R.drawable.flag_ly, 0, 1)
                , new Country("MA", "Morocco", "+212", R.drawable.flag_ma, 0, 1)
                , new Country("MC", "Monaco", "+377", R.drawable.flag_mc, 0, 1)
                , new Country("MD", "Moldova, Republic of", "+373", R.drawable.flag_md, 0, 1)
                , new Country("ME", "Montenegro", "+382", R.drawable.flag_me, 0, 1)
                , new Country("MF", "Saint Martin", "+590", R.drawable.flag_mf, 0, 1)
                , new Country("MG", "Madagascar", "+261", R.drawable.flag_mg, 0, 1)
                , new Country("MH", "Marshall Islands", "+692", R.drawable.flag_mh, 0, 1)
                , new Country("MK", "Macedonia, The Former Yugoslav Republic of", "+389", R.drawable.flag_mk, 0, 1)
                , new Country("ML", "Mali", "+223", R.drawable.flag_ml, 0, 1)
                , new Country("MM", "Myanmar", "+95", R.drawable.flag_mm, 0, 1)
                , new Country("MN", "Mongolia", "+976", R.drawable.flag_mn, 0, 1)
                , new Country("MO", "Macao", "+853", R.drawable.flag_mo, 0, 1)
                , new Country("MP", "Northern Mariana Islands", "+1", R.drawable.flag_mp, 0, 1)
                , new Country("MQ", "Martinique", "+596", R.drawable.flag_mq, 0, 1)
                , new Country("MR", "Mauritania", "+222", R.drawable.flag_mr, 0, 1)
                , new Country("MS", "Montserrat", "+1", R.drawable.flag_ms, 0, 1)
                , new Country("MT", "Malta", "+356", R.drawable.flag_mt, 0, 1)
                , new Country("MU", "Mauritius", "+230", R.drawable.flag_mu, 0, 1)
                , new Country("MV", "Maldives", "+960", R.drawable.flag_mv, 0, 1)
                , new Country("MW", "Malawi", "+265", R.drawable.flag_mw, 0, 1)
                , new Country("MX", "Mexico", "+52", R.drawable.flag_mx, 0, 1)
                , new Country("MY", "Malaysia", "+60", R.drawable.flag_my, 0, 1)
                , new Country("MZ", "Mozambique", "+258", R.drawable.flag_mz, 0, 1)
                , new Country("NA", "Namibia", "+264", R.drawable.flag_na, 0, 1)
                , new Country("NC", "New Caledonia", "+687", R.drawable.flag_nc, 0, 1)
                , new Country("NE", "Niger", "+227", R.drawable.flag_ne, 0, 1)
                , new Country("NF", "Norfolk Island", "+672", R.drawable.flag_nf, 0, 1)
                , new Country("NG", "Nigeria", "+234", R.drawable.flag_ng, 0, 1)
                , new Country("NI", "Nicaragua", "+505", R.drawable.flag_ni, 0, 1)
                , new Country("NL", "Netherlands", "+31", R.drawable.flag_nl, 0, 1)
                , new Country("NO", "Norway", "+47", R.drawable.flag_no, 0, 1)
                , new Country("NP", "Nepal", "+977", R.drawable.flag_np, 0, 1)
                , new Country("NR", "Nauru", "+674", R.drawable.flag_nr, 0, 1)
                , new Country("NU", "Niue", "+683", R.drawable.flag_nu, 0, 1)
                , new Country("NZ", "New Zealand", "+64", R.drawable.flag_nz, 0, 1)
                , new Country("OM", "Oman", "+968", R.drawable.flag_om, 0, 1)
                , new Country("PA", "Panama", "+507", R.drawable.flag_pa, 0, 1)
                , new Country("PE", "Peru", "+51", R.drawable.flag_pe, 0, 1)
                , new Country("PF", "French Polynesia", "+689", R.drawable.flag_pf, 0, 1)
                , new Country("PG", "Papua New Guinea", "+675", R.drawable.flag_pg, 0, 1)
                , new Country("PH", "Philippines", "+63", R.drawable.flag_ph, 0, 1)
                , new Country("PK", "Pakistan", "+92", R.drawable.flag_pk, 0, 1)
                , new Country("PL", "Poland", "+48", R.drawable.flag_pl, 0, 1)
                , new Country("PM", "Saint Pierre and Miquelon", "+508", R.drawable.flag_pm, 0, 1)
                , new Country("PN", "Pitcairn", "+872", R.drawable.flag_pn, 0, 1)
                , new Country("PR", "Puerto Rico", "+1", R.drawable.flag_pr, 0, 1)
                , new Country("PS", "Palestinian Territory, Occupied", "+970", R.drawable.flag_ps, 0, 1)
                , new Country("PT", "Portugal", "+351", R.drawable.flag_pt, 0, 1)
                , new Country("PW", "Palau", "+680", R.drawable.flag_pw, 0, 1)
                , new Country("PY", "Paraguay", "+595", R.drawable.flag_py, 0, 1)
                , new Country("QA", "Qatar", "+974", R.drawable.flag_qa, 0, 1)
                , new Country("RE", "Réunion", "+262", R.drawable.flag_re, 0, 1)
                , new Country("RO", "Romania", "+40", R.drawable.flag_ro, 0, 1)
                , new Country("RS", "Serbia", "+381", R.drawable.flag_rs, 0, 1)
                , new Country("RU", "Russia", "+7", R.drawable.flag_ru, 0, 1)
                , new Country("RW", "Rwanda", "+250", R.drawable.flag_rw, 0, 1)
                , new Country("SA", "Saudi Arabia", "+966", R.drawable.flag_sa, 9, 12)
                , new Country("SB", "Solomon Islands", "+677", R.drawable.flag_sb, 0, 1)
                , new Country("SC", "Seychelles", "+248", R.drawable.flag_sc, 0, 1)
                , new Country("SD", "Sudan", "+249", R.drawable.flag_sd, 0, 1)
                , new Country("SE", "Sweden", "+46", R.drawable.flag_se, 0, 1)
                , new Country("SG", "Singapore", "+65", R.drawable.flag_sg, 0, 1)
                , new Country("SH", "Saint Helena, Ascension and Tristan Da Cunha", "+290", R.drawable.flag_sh, 0, 1)
                , new Country("SI", "Slovenia", "+386", R.drawable.flag_si, 0, 1)
                , new Country("SJ", "Svalbard and Jan Mayen", "+47", R.drawable.flag_sj, 0, 1)
                , new Country("SK", "Slovakia", "+421", R.drawable.flag_sk, 0, 1)
                , new Country("SL", "Sierra Leone", "+232", R.drawable.flag_sl, 0, 1)
                , new Country("SM", "San Marino", "+378", R.drawable.flag_sm, 0, 1)
                , new Country("SN", "Senegal", "+221", R.drawable.flag_sn, 0, 1)
                , new Country("SO", "Somalia", "+252", R.drawable.flag_so, 0, 1)
                , new Country("SR", "Suriname", "+597", R.drawable.flag_sr, 0, 1)
                , new Country("SS", "South Sudan", "+211", R.drawable.flag_ss, 0, 1)
                , new Country("ST", "Sao Tome and Principe", "+239", R.drawable.flag_st, 0, 1)
                , new Country("SV", "El Salvador", "+503", R.drawable.flag_sv, 0, 1)
                , new Country("SX", "Sint Maarten", "+1", R.drawable.flag_sx, 0, 1)
                , new Country("SY", "Syrian Arab Republic", "+963", R.drawable.flag_sy, 0, 1)
                , new Country("SZ", "Swaziland", "+268", R.drawable.flag_sz, 0, 1)
                , new Country("TC", "Turks and Caicos Islands", "+1", R.drawable.flag_tc, 0, 1)
                , new Country("TD", "Chad", "+235", R.drawable.flag_td, 0, 1)
                , new Country("TF", "French Southern Territories", "+262", R.drawable.flag_tf, 0, 1)
                , new Country("TG", "Togo", "+228", R.drawable.flag_tg, 0, 1)
                , new Country("TH", "Thailand", "+66", R.drawable.flag_th, 0, 1)
                , new Country("TJ", "Tajikistan", "+992", R.drawable.flag_tj, 0, 1)
                , new Country("TK", "Tokelau", "+690", R.drawable.flag_tk, 0, 1)
                , new Country("TL", "East Timor", "+670", R.drawable.flag_tl, 0, 1)
                , new Country("TM", "Turkmenistan", "+993", R.drawable.flag_tm, 0, 1)
                , new Country("TN", "Tunisia", "+216", R.drawable.flag_tn, 0, 1)
                , new Country("TO", "Tonga", "+676", R.drawable.flag_to, 0, 1)
                , new Country("TR", "Turkey", "+90", R.drawable.flag_tr, 0, 1)
                , new Country("TT", "Trinidad and Tobago", "+1", R.drawable.flag_tt, 0, 1)
                , new Country("TV", "Tuvalu", "+688", R.drawable.flag_tv, 0, 1)
                , new Country("TW", "Taiwan", "+886", R.drawable.flag_tw, 0, 1)
                , new Country("TZ", "Tanzania, United Republic of", "+255", R.drawable.flag_tz, 0, 1)
                , new Country("UA", "Ukraine", "+380", R.drawable.flag_ua, 0, 1)
                , new Country("UG", "Uganda", "+256", R.drawable.flag_ug, 0, 1)
                , new Country("UM", "U.S. Minor Outlying Islands", "", R.drawable.flag_um, 0, 1)
                , new Country("US", "United States", "+1", R.drawable.flag_us, 0, 1)
                , new Country("UY", "Uruguay", "+598", R.drawable.flag_uy, 0, 1)
                , new Country("UZ", "Uzbekistan", "+998", R.drawable.flag_uz, 0, 1)
                , new Country("VA", "Holy See (Vatican City State)", "+379", R.drawable.flag_va, 0, 1)
                , new Country("VC", "Saint Vincent and the Grenadines", "+1", R.drawable.flag_vc, 0, 1)
                , new Country("VE", "Venezuela, Bolivarian Republic of", "+58", R.drawable.flag_ve, 0, 1)
                , new Country("VG", "Virgin Islands, British", "+1", R.drawable.flag_vg, 0, 1)
                , new Country("VI", "Virgin Islands, U.S.", "+1", R.drawable.flag_vi, 0, 1)
                , new Country("VN", "Viet Nam", "+84", R.drawable.flag_vn, 0, 1)
                , new Country("VU", "Vanuatu", "+678", R.drawable.flag_vu, 0, 1)
                , new Country("WF", "Wallis and Futuna", "+681", R.drawable.flag_wf, 0, 1)
                , new Country("WS", "Samoa", "+685", R.drawable.flag_ws, 0, 1)
                , new Country("XK", "Kosovo", "+383", R.drawable.flag_xk, 0, 1)
                , new Country("YE", "Yemen", "+967", R.drawable.flag_ye, 0, 1)
                , new Country("YT", "Mayotte", "+262", R.drawable.flag_yt, 0, 1)
                , new Country("ZA", "South Africa", "+27", R.drawable.flag_za, 0, 1)
                , new Country("ZM", "Zambia", "+260", R.drawable.flag_zm, 0, 1)
                , new Country("ZW", "Zimbabwe", "+263", R.drawable.flag_zw, 0, 1)
        };


    }

    public static class NameComparator implements Comparator<Country> {
        public NameComparator() {
        }

        public int compare(Country country, Country t1) {
            return country.name.compareTo(t1.name);
        }
    }

    public static class ISOCodeComparator implements Comparator<Country> {
        public ISOCodeComparator() {
        }

        public int compare(Country country, Country t1) {
            return country.code.compareTo(t1.code);
        }
    }
}

