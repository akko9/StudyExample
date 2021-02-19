package ReactorDemo;

import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestReactor {
    public static void main(String[] args) {
        //just声明
        Flux.just(1,2,3,4).subscribe(System.out::print);
        Mono.just(1);

//        //其他方式
//        Integer[] nums={1,2,3,4};
//        Flux.fromArray(nums);
//
//        List<Integer> list= Arrays.asList(1,2,3,4);
//        Flux.fromIterable(list);
//
//        Stream<Integer> stream=list.stream();
//        Flux.fromStream(stream);


    }
}
