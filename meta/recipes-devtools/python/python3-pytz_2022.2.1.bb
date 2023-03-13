SUMMARY = "World timezone definitions, modern and historical"
HOMEPAGE = "http://pythonhosted.org/pytz"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=1a67fc46c1b596cce5d21209bbe75999"

inherit pypi setuptools3 ptest

SRC_URI[sha256sum] = "cea221417204f2d1a2aa03ddae3e867921971d0d76f14d87abb4414415bbdcf5"

RDEPENDS:${PN}:class-target += "\
    ${PYTHON_PN}-datetime \
    ${PYTHON_PN}-doctest \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-pickle \
    ${PYTHON_PN}-pprint \
    ${PYTHON_PN}-threading \
"

BBCLASSEXTEND = "native nativesdk"

SRC_URI += " \
	file://run-ptest \
"

RDEPENDS:${PN}-ptest += " \
	${PYTHON_PN}-pytest \
"

do_install_ptest() {
	install -d ${D}${PTEST_PATH}/pytz
	install -d ${D}${PTEST_PATH}/pytz/tests
	cp -rf ${S}/pytz/tests/* ${D}${PTEST_PATH}/pytz/tests/
	cp -f ${S}/README.rst ${D}${PTEST_PATH}/

}
