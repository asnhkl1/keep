# keep

A keepAlive flutter plugin project.


Use:


  Future<void> initPlatformState() async {
    try {
      await Keep.keepAlive;
      print('Success to open keepAlive');
    } on PlatformException {
      print('Failed to open keepAlive');
    }
    if (!mounted) return;
  }
  
