package emporium.enumerations;

public enum Unit {
	
	K {
		@Override
		public String toString() {
			return "[K] Kilogram.";
		}
	},
	
	M {
		@Override
		public String toString() {
			return "[M] Meter.";
		}
	},
	
	L {
		@Override
		public String toString() {
			return "[L] Liter.";
		}
	},
	
	U {
		@Override
		public String toString() {
			return "[U] Unit.";
		}
	};

}
