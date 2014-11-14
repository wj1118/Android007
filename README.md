android 4.x 集训计划 11.14
===================

####Options menu and action bar
> The options menu is the primary collection of menu items for an activity. It's where you should place actions that have a global impact on the app, such as "Search," "Compose email," and "Settings."
If you're developing for Android 2.3 or lower, users can reveal the options menu panel by pressing the Menu button.
On Android 3.0 and higher, items from the options menu are presented by the action bar as a combination of on-screen action items and overflow options. Beginning with Android 3.0, the Menu button is deprecated (some devices don't have one), so you should migrate toward using the action bar to provide access to actions and other options.
See the section about Creating an Options Menu.
####Context menu and contextual action mode
> A context menu is a floating menu that appears when the user performs a long-click on an element. It provides actions that affect the selected content or context frame.
When developing for Android 3.0 and higher, you should instead use the contextual action mode to enable actions on selected content. This mode displays action items that affect the selected content in a bar at the top of the screen and allows the user to select multiple items.
See the section about Creating Contextual Menus.
####Popup menu
> A popup menu displays a list of items in a vertical list that's anchored to the view that invoked the menu. It's good for providing an overflow of actions that relate to specific content or to provide options for a second part of a command. Actions in a popup menu should not directly affect the corresponding content—that's what contextual actions are for. Rather, the popup menu is for extended actions that relate to regions of content in your activity.
See the section about Creating a Popup Menu.

Android Promote Plan by TcXiaoyi Co. Ltd
