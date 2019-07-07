package pl.cinema.server


import java.nio.charset.StandardCharsets

import static org.assertj.core.api.Assertions.contentOf

class JsonToStringParser {
    private static final String SRC_TEST_RESOURCES_JSON = "src/test/resources/json/"

    static String getJsonString(String fileName) {
        return contentOf(new File(SRC_TEST_RESOURCES_JSON + fileName), StandardCharsets.UTF_8)
    }
}
