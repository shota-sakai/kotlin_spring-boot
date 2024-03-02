
import org.junit.jupiter.api.Test
import com.example.demo.utils.EventBridgeUtils

class EventBridgeUtilsTest(){
  @Test
  fun test01(){
    EventBridgeUtils("ap-northeast-1").triggerCustomRule()
  }
}