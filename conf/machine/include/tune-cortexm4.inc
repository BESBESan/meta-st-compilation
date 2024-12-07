# Tuning pour Cortex-M4
TUNE_FEATURES_tune-cortexm4 = "arm armv7-m cortexm4"
TUNE_PKGARCH_tune-cortexm4 = "cortexm4"
BASE_LIB_tune-cortexm4 = "lib"

# Options spécifiques au compilateur pour Cortex-M4
ARM_INSTRUCTION_SET = "thumb"
TUNE_CCARGS = "-mcpu=cortex-m4 -mthumb"
