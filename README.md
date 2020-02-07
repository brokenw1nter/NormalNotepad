# NormalNotepad
A "Normal" Notepad that is written in Java and Console based. With a twist, that being each document is serialized and the notepad is "HIGHLY" secure! You'll be able to create encrypted documents on the fly! Never have your notes seen by prying eyes ever again!
## Changelog (2.7.2020 03:40)
- Implemented Document Object
- Added Secondary View/Edit Menu
- Implemented Simple Single Line Documents
- Implemented Serialization and Deserialization of Documents
## Known Bugs
- Viewing an empty document causes NullPointerExceptions
## Questions and Answers
- Q: Why is this console based?
- A: Why not? It's not very practical but it's something I thought would be interesting.
- Q: Why does this require a login?
- A: It doesn't but makes it more "hacker" themed and keeps your serialized documents from being seen by anyone.
- Q: Can I change the username and password?
- A: Yes you can, security logic is under LogicController.java. Yes it is very basic and not very secure. As it's not meant to be.
