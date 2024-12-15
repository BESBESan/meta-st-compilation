# Optimisations pour Cortex-M4
TUNE_FEATURES_tune-cortexm4 = "armv7-m cortex-m4 thumb"
TUNE_PKGARCH_tune-cortexm4 = "cortexm4"
TUNE_ARCH = "arm"

# Options du compilateur
TARGET_CC_ARCH = "-mcpu=cortex-m4 -mthumb -mfpu=fpv4-sp-d16 -mfloat-abi=hard"
