package com.woowacourse.thankoo.acceptance.support.fixtures;

import static com.woowacourse.thankoo.acceptance.support.fixtures.RestAssuredRequestFixture.getWithToken;
import static com.woowacourse.thankoo.acceptance.support.fixtures.RestAssuredRequestFixture.postWithToken;

import com.woowacourse.thankoo.coupon.application.dto.CouponRequest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.http.HttpHeaders;

public class CouponHistoryRequestFixture {

    public static ExtractableResponse<Response> 쿠폰을_전송한다(final String accessToken,
                                                         final CouponRequest couponRequest) {
        return postWithToken("/api/coupons/send", accessToken, couponRequest);
    }

    public static Long 쿠폰이_추가됨(final ExtractableResponse<Response> response) {
        return Long.valueOf(response.header(HttpHeaders.LOCATION).split("/coupons/")[1]);
    }

    public static ExtractableResponse<Response> 쿠폰을_조회한다(final String accessToken) {
        return getWithToken("/api/coupons/received", accessToken);
    }
}
