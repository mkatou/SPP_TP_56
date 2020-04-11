# SPP_TP_56

# --------------- WORK STRUCTURING ---------------
      

The Tp consists of 3 parts, and we have created 6 packages:

# -- package Lab_5_6_LabFiles_2020
    This package includes all the other 5 packages. It is the main package of the TP

# -- package Lab_5_6_LabFiles_2020.interfaces
    This package includes all interfaces:
      - interface IFilter
      - interface IImageFilteringEngine
      - interface BufferedImageTools 


# -- package Lab_5_6_LabFiles_2020.partie_1
    This package includes all the classes in Part I of the TP:
      - class GaussianContourExtractorFilter
      - class GrayFilter
      - class SingleThreadedImageFilteringEngine 
      - class Main

# -- package Lab_5_6_LabFiles_2020.partie_2
    This package includes all the classes in Part II of the TP:
      - class ImageFilteringEngineExe
      - class MultiThreaded_ImageFilteringEngine
      - class Main

# -- package Lab_5_6_LabFiles_2020.partie_3
    This package includes all the classes in Part III of the TP:
      - class PerformanceAnalysis
      - class Main

# -- package Lab_5_6_LabFiles_2020.tests
    This package includes all the TP tests:
      - class FilesComparator 
      - class Partie_1JUnitTest
      - class Partie_2JUnitTest

Also we have the folder "TEST_IMAGES"  which contains all the test images.

