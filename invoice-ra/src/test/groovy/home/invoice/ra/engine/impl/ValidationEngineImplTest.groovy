package home.invoice.ra.engine.impl

import home.invoice.ra.engine.ValidationEngine
import spock.lang.Specification


/**
 * Spock unit tests cases for {@link ValidationEngineImpl}
 *
 * @author patm11
 * Created on 6/27/20
 */
class ValidationEngineImplTest extends Specification {

    ValidationEngine engine

    def setup() {
        engine = new ValidationEngineImpl()
    }

    def "Validating invoice ID's produces the expected results given varying input"(String id, boolean expected) {
        expect:
            engine.validateInvoiceId(id).isEmpty() == expected

        where:
            id          | expected
            "123"       | true
            "Blah"      | false
            null        | false
            ""          | false
    }
}
