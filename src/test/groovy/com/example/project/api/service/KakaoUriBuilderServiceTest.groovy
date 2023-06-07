package com.example.project.api.service


import spock.lang.Specification

import java.nio.charset.StandardCharsets


class KakaoUriBuilderServiceTest extends Specification {

    private KakaoUriBuilderService kakaoUrilBuilderService

    def setup() {
        kakaoUrilBuilderService = new KakaoUriBuilderService()
    }

    def "buildUriByAddressSearch - 한글 파라미터의 경우 정상적으로 인코딩"() {
        given:
        String address = "서울 성북구"
        def charset = StandardCharsets.UTF_8

        when:
        def uri = kakaoUrilBuilderService.buildUriByAddressSearch(address)
        def decodeResult = URLDecoder.decode(uri.toString(), charset)

        then:
        decodeResult == "https://dapi.kakao.com/v2/local/search/address.json?query=서울 성북구"
    }

}