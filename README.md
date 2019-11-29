# MagicTip

[![](https://jitpack.io/v/Devit951/MagicTip.svg)](https://jitpack.io/#Devit951/MagicTip)
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-MagicTip-green.svg?style=flat )]( https://android-arsenal.com/details/1/7962 )
![](https://ci5.googleusercontent.com/proxy/LLcEjp3PS_t4HrRKqAzo0HHMLRje-z8nWcFsO1sbhmlySW-Zhte3s8IC-TddsbqlFC9ZKHJwbvdwW0IHVhaiftfXX--Zr3_s5bhC8S5kT2EX11cgVXAnfmPyZn7jPk9b_v2CCixTWkwj=s0-d-e1-ft#https://github.com/vbauer/android-arsenal.com/raw/master/misc/android-arsenal-logo.png)

![20191114_151821](https://user-images.githubusercontent.com/21290800/68848808-c1b5f080-06f2-11ea-8dee-d3ffaef86a9c.gif)


## Simple MagicTip
```
MagicTip(anchorView)
                    .settings {
                        text = "Lorem Posen"
                        bgColor = Color.RED
                    }
                    .show()
             
```

## AutoCloseMagicTip
AutoCloseMagicTip by default close tip after 1000 milliseconds. You can change it in the constructor: 

```
AutoCloseMagicTip(anchorView, delayMillis)
                    .settings {
                        text = "Lorem Posen"
                        bgColor = Color.GREEN
                    }
                    .show()
 ```              
 
## OneMagicTip
OneMagicTip - it is decorator that shows only 1 MagicTip.
 ```
 OneMagicTip(anchorView, MagicTip(anchorView)
                    .settings {
                        text = "Lorem Posen"
                        bgColor = Color.BLUE
                    })
                    .show()
 ```
 
## How to use animations?
In the `MagicTip.(view).settings{ }` block of code you have access to `startAnimationDelegate` and `exitAnimationDelegate`. 
Don't forget to set **Reversed** version of animation on `exitAnimationDelegate`. For example if `startAnimationDelegate = OvershootMagicTipAnimation()` then `exitAnimationDelegate = OvershootMagicTipAnimation.Reversed()`

Set of animations: 
- AlphaMagicTipAnimation
- OvershootMagicTipAnimation
- ScaledTranslateMagicTipAnimation
 
 
## Download 
`implementation 'com.github.Devit951:MagicTip:1.0.0'`
