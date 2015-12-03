# Circle progress view for react-native android

A react native android module to show a circle progress view based on Circle-Progress-View (https://github.com/jakob-grabner/Circle-Progress-View).

## Setup

* install module

```bash
 npm i --save react-native-android-circles
```

* `android/build.gradle`

```gradle
...
allprojects {
    ...
    repositories {
      ...
      maven { url "https://jitpack.io" }
    }
    ...

}
```

* `android/settings.gradle`

```gradle
...
include ':react-native-android-circles'
project(':react-native-android-circles').projectDir = new File(settingsDir, '../node_modules/react-native-android-circles')
```

* `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':react-native-android-circles')
}
```

* register module (in MainActivity.java)

```java
import com.kwaak.react.CirclesPackage;  // <--- import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {

  ......
  private static Activity mActivity = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mActivity = this;
    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new MainReactPackage())
      .addPackage(new CirclesPackage())      // <------- add package
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "ExampleRN", null);

    setContentView(mReactRootView);
  }

  ......

}
```

## Usage

```js
var Circles = require('react-native-android-circles');

  <Circles
    style={{width: 250, height: 250}}}
    сontourColor="#f4f4f4"
    rimColor="#f4f4f4"
    barColors={["#15e064", "#17aecc", "#15e064"]}
    value={90}
    maxValue={100}
    сontourSize={280}
    rimWidth={120}
    barWidth={100}
    animated={true}
  />

```
