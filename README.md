# NaughtyJavaAnnotations

## Perface

This repo was just set up when I am doing some test on some java project,

When I want to add a temp test `public static void main(String[] args)` and add a `@Temp` or a `@Test` annotion for the function.


## Principle

These annotations do not modify any line of code nor do some magic to your code and just add some annotations for notification.

Some annotations have magic useages, we will adress it in the usage chapter.



## Usage

Some annotations are just Naughty, such as:

```
import com.mudu.annotations.*;

@Controller
@RequestMapping("z")
public class ZiaoController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(ZiaoController.class);

    @Autowired
    private AppInfoService appInfoService;

    @Temp
    @TestWhenDeveloping
    @MagicAndDoNotModifyIt
    @Fuck("somebody")
    @ThisCodeWasCreatedAt("2016 07 12")
    @TestedBy("someone")
    public static void main(String[] args) {
        try {
            //Use Object instead of an Map<Map>
            Object b = DeptService.getDeptNodeList();
            System.out.println(JSON.toJSONString(b));

            Object c = OrgService.getTree();
            System.out.println(JSON.toJSONString(c));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
```


## Method ahd util pair:

#### UmImplementedMethod and correspoinding util
```
@UnImplementedMethod("i will implement it later")
public void dropColumn() {
}

//Use this method to get all annotation with UnImplementedMethod
UnImplementedMethodUtil.scan("com.my.mdb")
```


## List

For usage, read the usage section.

The annotations List is:

```
AddTemporarilyForTest
DoNotModify
Fuck
ItMayWorksButIAmNotSure
ItWorksOVersion
ItWorksOnMyComputer
JavaVersionMustSatisfy
MagicAndDoNotModifyIt
PoweredBy
ProudlyPoweredBy
StrutsSucks
Temp
TestWhenDeveloping
TestedBy
TheCorrespodingSQLIs
ThisCodeWasCreatedAt
```